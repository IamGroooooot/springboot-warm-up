package com.warmup.libraryapp.service.user;

import com.warmup.libraryapp.domain.User;
import com.warmup.libraryapp.dto.user.request.UserCreateRequest;
import com.warmup.libraryapp.dto.user.response.UserResponse;
import com.warmup.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest userCreateRequest) {
        userRepository.saveUser(userCreateRequest.getName(), userCreateRequest.getAge());
    }

    public List<UserResponse> getUser() {
        List<User> users = userRepository.getAllUser();
        return UserResponse.from(users);
    }
}
