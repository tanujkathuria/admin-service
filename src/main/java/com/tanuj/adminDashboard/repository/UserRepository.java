package com.tanuj.adminDashboard.repository;

import com.tanuj.adminDashboard.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserRepository {

    private static List<User> userlist = new ArrayList<User>();

    private static int usersCount = 4;


    static {
        userlist.add(new User(1,"adam",new Date()));
        userlist.add(new User(2,"eve",new Date()));
        userlist.add(new User(3,"jack",new Date()));
        userlist.add(new User(4,"rahul",new Date()));
    }

    public List<User> findAll(){
        return userlist;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        userlist.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : userlist){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> userIterator = userlist.iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getId() == id){
                userIterator.remove();
                return user;
            }
        }
        return null;

    }

}
