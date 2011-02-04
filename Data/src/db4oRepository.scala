import collection.mutable.MutableList
import com.db4o.config.Configuration
import com.db4o.{ObjectSet, Db4o, ObjectContainer}
import java.io.File
import com.reviewQueue.data.IncrementedId
import com.reviewQueue.model.Entity
import java.lang.reflect.ParameterizedType
import scala.collection.JavaConversions.asScalaBuffer

class db4oRepository[T <: Entity](dbFilePath: String)(implicit man: Manifest[T]) {
  private var oc : ObjectContainer = _
  val config = Db4o.newConfiguration
  //protected var tClass : Class[T] = (getClass().getGenericSuperclass()).asInstanceOf[ParameterizedType].getActualTypeArguments()(0).asInstanceOf[Class[T]]
  protected var tClass  = man.erasure.asInstanceOf[Class[T]]
  //def this(implicit man: Manifest[T], dbFilePath: String) = this(man, dbFilePath, Db4o.newConfiguration())

  protected def db: ObjectContainer = {
    try {
      if (oc == null || oc.ext.isClosed) oc = Db4o.openFile(config, dbFilePath)
      return oc
    }
    catch {
      case e: Exception => {
        return null
      }
    }
  }

  def close: Unit = {
    if (oc != null) {
      oc.close
      oc = null
    }
  }

  def commit: Unit = {
    db.commit
  }

  def rollback: Unit = {
    db.rollback
  }

  def save(entity: T): Unit = {
    if (entity.Id == 0) entity.Id = getNextId
    db.store(entity)
    db.commit
  }

  def getAll : List[T] = {
    val results = db.query(tClass)
    return results.toList
  }

  def getById(id: Int): T = {
    var example : T = tClass.newInstance
    example.Id = id
    var results = db.queryByExample(example)
    if (results.size == 0) return null.asInstanceOf[T]
    return results.get(0)
  }

  def deleteDatabase: Unit = {
    close
    new File(dbFilePath).delete
  }

  def backup(path: String): Unit = {
    db.ext.backup(path)
  }

  def restore(path: String): Unit = {
    deleteDatabase
    new File(path).renameTo(new File(dbFilePath))
    new File(path).delete
  }

  def getNextId: Int = {
    var result: ObjectSet[IncrementedId] = db.queryByExample(classOf[IncrementedId])
    var ii: IncrementedId = null
    var nextId: Int = 0
    if (result.hasNext) {
      ii = result.next.asInstanceOf[IncrementedId]
    }
    else {
      ii = new IncrementedId
    }
    nextId = ii.getNextID
    db.store(ii)
    return nextId
  }
}