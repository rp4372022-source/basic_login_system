package com.basic_login_system;

import com.basic_login_system.model.User;
import com.basic_login_system.repository.UserRepo;
import com.basic_login_system.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LoginSystemApplication {

	public static void main(String[] args) {
		ApplicationContext contex = SpringApplication.run(LoginSystemApplication.class, args);

//		UserService userService = contex.getBean(UserService.class);
//
//		User user1 = new User("Rutik","abc@123","abc@123");
//
//		userService.addUser(user1);

		UserRepo repo = contex.getBean(UserRepo.class);
		User user1 = repo.findUserByName("Rutik");
		System.out.println(user1);
	}

}
