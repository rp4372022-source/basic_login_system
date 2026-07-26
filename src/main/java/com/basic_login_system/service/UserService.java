package com.basic_login_system.service;
import com.basic_login_system.model.User;
import com.basic_login_system.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean addUser(User user){
        List<User> userList = userRepo.getAllUsers();
        if(userList.contains(user)){
            return false;
        }
        userRepo.addUser(user);
        return true;
    }
    public void login(User user){}
}
