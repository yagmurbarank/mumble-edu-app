package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.User;
import com.OnlineCoursePlatform.model.request.RegisterRequest;
import com.OnlineCoursePlatform.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RegisterController {

     private final UserService userService;

    public RegisterController(UserService userService) {

        this.userService = userService;
    }


    @PostMapping("/register")
    public User addUser(@Valid @RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setRole(registerRequest.getRole());
        return userService.addUser(user);
    }
}
