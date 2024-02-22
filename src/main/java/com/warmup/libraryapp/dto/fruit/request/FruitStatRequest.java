package com.warmup.libraryapp.dto.fruit.request;

public class FruitStatRequest {
    private String name;

    public FruitStatRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
