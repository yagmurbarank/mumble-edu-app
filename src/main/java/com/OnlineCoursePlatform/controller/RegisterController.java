package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.User;
import com.OnlineCoursePlatform.model.request.UserRequestDTO;
import com.OnlineCoursePlatform.service.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RegisterController {

     private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/register")
//    public User addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
//        User user = new User();
//        user.setName(userRequestDTO.getName());
//        user.setEmail(userRequestDTO.getEmail());
//        user.setPassword(userRequestDTO.getPassword());
//        user.setRole(userRequestDTO.getRole());
//        return userService.addUser(user);
//    }
}
