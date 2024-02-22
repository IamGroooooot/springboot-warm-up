package com.warmup.libraryapp.domain;

import java.time.LocalDate;

public class Fruit {
    private String name;
    private LocalDate warehousingDate;
    private Long price;

    private boolean isSold;

    public Fruit(String name, LocalDate warehousingDate, Long price, boolean isSold) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = isSold;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }


    public boolean isSold() {
        return isSold;
    }
}
