package com.warmup.libraryapp.service.fruit;

import com.warmup.libraryapp.domain.Fruit;
import com.warmup.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.warmup.libraryapp.dto.fruit.request.FruitSellRequest;
import com.warmup.libraryapp.dto.fruit.request.FruitStatRequest;
import com.warmup.libraryapp.dto.fruit.response.FruitCreateResponse;
import com.warmup.libraryapp.dto.fruit.response.FruitSellResponse;
import com.warmup.libraryapp.dto.fruit.response.FruitStatResponse;
import com.warmup.libraryapp.repository.fruit.FruitRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public FruitCreateResponse CreateFruit(FruitCreateRequest request) {
        Fruit fruit = fruitRepository.createFruit(request.getName(), request.getWarehousingDate(), request.getPrice(), false);
        return new FruitCreateResponse(fruit);
    }

    public FruitSellResponse sellFruit(FruitSellRequest request) {
        fruitRepository.updateFruit(request.getId());
        return new FruitSellResponse(request.getId());
    }

    public FruitStatResponse getFruitStat(FruitStatRequest request) {
        List<Fruit> fruits = fruitRepository.getFruits(request.getName());

        long totalAmount = fruits.stream().mapToLong(Fruit::getPrice).sum();
        long salesAmount = fruits.stream().filter(Fruit::getIsSold).mapToLong(Fruit::getPrice).sum();
        long notSalseAmount = totalAmount - salesAmount;
        return new FruitStatResponse(salesAmount, notSalseAmount);
    }
}
