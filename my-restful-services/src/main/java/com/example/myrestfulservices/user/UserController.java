package com.example.myrestfulservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }
    
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.save(user);
    }
}
