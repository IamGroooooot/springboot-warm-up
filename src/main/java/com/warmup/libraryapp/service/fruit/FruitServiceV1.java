package com.warmup.libraryapp.service.fruit;

import com.warmup.libraryapp.domain.Fruit;
import com.warmup.libraryapp.dto.fruit.request.*;
import com.warmup.libraryapp.dto.fruit.response.*;
import com.warmup.libraryapp.repository.fruit.FruitRepositoryV1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceV1 implements FruitService {
    private final FruitRepositoryV1 fruitRepositoryV1;

    public FruitServiceV1(FruitRepositoryV1 fruitRepositoryV1) {
        this.fruitRepositoryV1 = fruitRepositoryV1;
    }

    @Override
    public FruitCreateResponse CreateFruit(FruitCreateRequest request) {
        Fruit fruit = fruitRepositoryV1.createFruit(request.getName(), request.getWarehousingDate(), request.getPrice(), false);
        return new FruitCreateResponse(fruit);
    }

    @Override
    public FruitSellResponse sellFruit(FruitSellRequest request) {
        fruitRepositoryV1.updateFruit(request.getId());
        return new FruitSellResponse(request.getId());
    }

    @Override
    public FruitStatResponse getFruitStat(FruitStatRequest request) {
        List<Fruit> fruits = fruitRepositoryV1.getFruits(request.getName());

        long totalAmount = fruits.stream().mapToLong(Fruit::getPrice).sum();
        long salesAmount = fruits.stream().filter(Fruit::getIsSold).mapToLong(Fruit::getPrice).sum();
        long notSalesAmount = totalAmount - salesAmount;
        return new FruitStatResponse(salesAmount, notSalesAmount);
    }

    @Override
    public FruitCountResponse getFruitCount(FruitCountRequest request) {
        return null;
    }

    @Override
    public List<FruitListResponse> getFruitList(FruitListRequest request) {
        return null;
    }
}
