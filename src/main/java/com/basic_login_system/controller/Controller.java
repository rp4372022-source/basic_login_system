package com.basic_login_system.controller;

import com.basic_login_system.model.User;
import com.basic_login_system.repository.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    // 1. Declare the repository as final
    private final UserRepo userRepo;

    // 2. Use constructor injection to let Spring automatically inject the bean
    public Controller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/getuser/{username}")
    public User findUser(@PathVariable String username){
        return userRepo.findUserByName(username);
    }
}
