package com.warmup.libraryapp.domain;

import java.time.LocalDate;

public class Fruit {
    private final Long id; // for memory repository
    private final String name;
    private final LocalDate warehousingDate;
    private final Long price;

    private boolean isSold;

    public Fruit(String name, LocalDate warehousingDate, Long price, boolean isSold) {
        this(-1L, name, warehousingDate, price, isSold);
    }

    public Fruit(Long id, String name, LocalDate warehousingDate, Long price, boolean isSold) {
        this.id = id;
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

    public boolean getIsSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
    public Long getId() {
        return id;
    }
}
