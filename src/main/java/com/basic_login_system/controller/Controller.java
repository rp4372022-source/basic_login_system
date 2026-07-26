package com.basic_login_system.controller;

import com.basic_login_system.model.User;
import com.basic_login_system.repository.UserRepo;
import com.basic_login_system.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    // 1. Declare the repository as final
    private final UserRepo userRepo;
    private final UserService userService;
    // 2. Use constructor injection to let Spring automatically inject the bean
    public Controller(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping("/")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/getuser/{username}")
    public User findUser(@PathVariable String username){
        return userRepo.findUserByName(username);
    }

    @PostMapping("/adduser")
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
