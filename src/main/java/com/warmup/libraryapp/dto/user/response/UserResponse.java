package com.warmup.libraryapp.dto.user.response;

public class UserResponse {
    private long id;
    private String name;
    private String age;

    public UserResponse(long id, String name, String age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
