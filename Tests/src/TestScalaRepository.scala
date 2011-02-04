import com.reviewQueue.model.User
import junit.framework.TestCase
import junit.framework._
import scala.collection.JavaConversions._

class TestScalaRepository extends TestCase {

  def test_db4oRepository: Unit = {
    val dir: String = System.getProperty("user.dir") + "\\test.db4o"
    val repository = new db4oRepository[User](dir)
    val u: User = new User
    u.FullName = "Rupert Bates"
    u.Email = "rupert.bates@guardian.co.uk"
    repository.save(u)
    val users = repository.getAll
    var size = users
      .filter(u => u.Email.startsWith("rupert"))
      .size
    Assert.assertTrue(users.size > 0);
    var u2 = repository.getById(1)


  }

  def test_implicit_conversion() {
    //var jlist : java.util.LinkedList = new java.util.[String]
    //jlist.add("test1", "test2")

  }

  def test_manifest() {
    class XYZ[T](implicit man: Manifest[T]) {
      def getOne: T = man.erasure.newInstance.asInstanceOf[T]
    }
    class Dog {
      def bark = "Woof"
    }
    val xyz = new XYZ[Dog]
    xyz.getOne.bark
  }

}