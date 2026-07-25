package com.basic_login_system.service;
import com.basic_login_system.model.User;
import com.basic_login_system.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user){
        userRepo.addUser(user);
    }
    public void login(User user){}
}
