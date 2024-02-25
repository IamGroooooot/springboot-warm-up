package com.warmup.libraryapp.domain;

public class User {
    private final Long id;
    private String name;
    private int age;

    public User(Long id, String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(String.format("Wrong name: %s", name));
        }
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }
}
