package com.warmup.libraryapp.dto.user.response;

import com.warmup.libraryapp.domain.User;

import java.util.List;

public class UserResponse {
    private final long id;
    private final String name;
    private final int age;


    public UserResponse(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static List<UserResponse> from(List<User> users) {
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .toList();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
