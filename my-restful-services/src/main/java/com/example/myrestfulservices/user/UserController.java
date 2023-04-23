package com.example.myrestfulservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("Id(%s) not found",id));
        }
        return user;
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newUser.getId())
            .toUri();
        
        // 생성되었다는 Status 반환 (201)
        // header.location: http://localhost:8088/users/4 + {id}를 바로 확인 가능
        return ResponseEntity.created(location).build(); 
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user == null){
            throw new UserNotFoundException(String.format("Id(%s) not found",id));
        }
    }

}
