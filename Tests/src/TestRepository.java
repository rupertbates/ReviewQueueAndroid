import com.reviewQueue.data.repositories.Repository;
import com.reviewQueue.data.repositories.UserRepository;
import com.reviewQueue.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestRepository {

    @Test
    public void can_insert_user_locally(){
        String dir = System.getProperty("user.dir") + "\\test.db4o";
        UserRepository repository = new UserRepository(dir);
        User u = new User();
        u.FullName = "Rupert Bates";
        u.Email = "rupert.bates@guardian.co.uk";
        repository.save(u);
        List<User> users = repository.getAll();
        Assert.assertTrue(users.size() > 0);
    }

}
