package com.reviewQueue.data.repositories;


import com.reviewQueue.model.User;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rupert bates
 * Date: 26/01/11
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class UserRepository extends Repository<User>{
    public UserRepository(String dbFilePath){
        super(dbFilePath);
    }


}
