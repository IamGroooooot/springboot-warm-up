package com.warmup.libraryapp.dto.fruit.response;

public class FruitStatResponse {
    private final Long salesAmount;
    private final Long notSalesAmount;

    public FruitStatResponse(Long salesAmount, Long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public Long getSalesAmount() {
        return salesAmount;
    }

    public Long getNotSalesAmount() {
        return notSalesAmount;
    }
}
