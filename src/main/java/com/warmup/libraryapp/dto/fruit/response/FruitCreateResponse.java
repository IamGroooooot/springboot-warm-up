package com.warmup.libraryapp.dto.fruit.response;

import com.warmup.libraryapp.domain.Fruit;

public class FruitCreateResponse {
    private String name;
    private String warehousingDate;
    private Long price;

    public FruitCreateResponse(Fruit fruit) {
        this.name = fruit.getName();
        this.warehousingDate = fruit.getWarehousingDate().toString();
        this.price = fruit.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarehousingDate() {
        return warehousingDate;
    }

    public void setWarehousingDate(String warehousingDate) {
        this.warehousingDate = warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
