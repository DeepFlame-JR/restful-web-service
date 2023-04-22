package com.example.myrestfulservices.user;

import java.util.*;

import org.springframework.stereotype.Service;

@Service  // Spring에서 UserDaoService를 어떤 용도로 사용할지 판단한다
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount=3;

    static{
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "Elena", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

}
