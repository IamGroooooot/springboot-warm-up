package com.warmup.libraryapp.controller.user;

import com.warmup.libraryapp.dto.user.request.UserCreateRequest;
import com.warmup.libraryapp.dto.user.response.UserResponse;
import com.warmup.libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest userCreateRequest) {
        userService.saveUser(userCreateRequest);
    }

    @GetMapping("/user")
    public List<UserResponse> getUser() {
        return userService.getUser();
    }
}