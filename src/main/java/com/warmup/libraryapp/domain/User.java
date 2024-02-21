package com.warmup.libraryapp.domain;

public class User {
    private String name;
    private String age;

    public User(String name, String age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(String.format("Wrong name: %s", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
