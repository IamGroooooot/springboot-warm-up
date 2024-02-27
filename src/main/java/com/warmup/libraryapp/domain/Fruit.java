package com.warmup.libraryapp.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // for memory repository
    private String name;
    @Column(name = "warehousing_date")
    private LocalDate warehousingDate;
    private Long price;

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

    public Fruit() {

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

    public void setIsSold(boolean sold) {
        isSold = sold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
