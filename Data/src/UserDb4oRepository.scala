import com.reviewQueue.model.User


class UserDb4oRepository(dbFilePath: String)
  extends db4oRepository[User](dbFilePath)
{

}
