package com.basic_login_system.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public User(){}
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(int id,String name,String email,String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
