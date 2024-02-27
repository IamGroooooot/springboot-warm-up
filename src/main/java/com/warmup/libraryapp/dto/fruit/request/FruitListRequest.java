package com.warmup.libraryapp.dto.fruit.request;

public class FruitListRequest {
    private final String option;
    private final Long price;

    public FruitListRequest(String option, Long price) {
        this.option = option;
        this.price = price;
    }

    public String getOption() {
        return option;
    }

    public Long getPrice() {
        return price;
    }
}
