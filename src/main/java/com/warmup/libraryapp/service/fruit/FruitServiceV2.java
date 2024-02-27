package com.warmup.libraryapp.service.fruit;

import com.warmup.libraryapp.domain.Fruit;
import com.warmup.libraryapp.domain.FruitRepository;
import com.warmup.libraryapp.dto.fruit.request.*;
import com.warmup.libraryapp.dto.fruit.response.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class FruitServiceV2 implements FruitService {
    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    @Override
    public FruitCreateResponse CreateFruit(FruitCreateRequest request) {
        Fruit fruit = fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice(), false));
        return new FruitCreateResponse(fruit);
    }

    @Override
    public FruitSellResponse sellFruit(FruitSellRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(() -> new IllegalArgumentException("해당하는 과일이 없습니다."));
        fruit.setIsSold(true);
        fruitRepository.save(fruit);
        return new FruitSellResponse(fruit.getId());
    }

    @Override
    public FruitStatResponse getFruitStat(FruitStatRequest request) {
        List<Fruit> fruits = fruitRepository.findAllByName(request.getName());
        long totalAmount = fruits.stream().mapToLong(Fruit::getPrice).sum();
        long salesAmount = fruits.stream().filter(Fruit::getIsSold).mapToLong(Fruit::getPrice).sum();
        long notSalesAmount = totalAmount - salesAmount;
        return new FruitStatResponse(salesAmount, notSalesAmount);
    }

    @Override
    public FruitCountResponse getFruitCount(FruitCountRequest request) {
        long count = fruitRepository.countByName(request.getName());
        return new FruitCountResponse(count);
    }

    @Override
    public List<FruitListResponse> getFruitList(FruitListRequest request) {
        String option = request.getOption();
        List<FruitListResponse> fruitListResponses = new ArrayList<>();
        List<Fruit> fruits;
        if (option.equals("GTE")) {
            fruits = fruitRepository.findAllByPriceGreaterThanEqualAndIsSoldFalse(request.getPrice());
        } else if (option.equals("LTE")) {
            fruits = fruitRepository.findAllByPriceLessThanEqualAndIsSoldFalse(request.getPrice());
        } else {
            throw new IllegalArgumentException("잘못된 옵션입니다.");
        }

        for (Fruit fruit : fruits) {
            fruitListResponses.add(new FruitListResponse(fruit));
        }

        return fruitListResponses;
    }
}
