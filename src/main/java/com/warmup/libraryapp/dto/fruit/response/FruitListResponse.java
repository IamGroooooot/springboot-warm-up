package com.warmup.libraryapp.dto.fruit.response;

import com.warmup.libraryapp.domain.Fruit;

import java.time.LocalDate;

public class FruitListResponse {
    private final String name;
    private final Long price;

    private final LocalDate warehousingDate;

    public FruitListResponse(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public FruitListResponse(Fruit fruit) {
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousingDate();
    }


    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
