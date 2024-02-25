package com.warmup.libraryapp.repository.user;

import com.warmup.libraryapp.domain.User;

import java.util.List;

public interface UserRepository {
    void saveUser(String name, int age);

    boolean isUserExist(Long id);

    List<User> getAllUser();
}