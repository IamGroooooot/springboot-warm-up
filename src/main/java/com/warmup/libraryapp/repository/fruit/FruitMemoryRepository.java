package com.warmup.libraryapp.repository.fruit;

import com.warmup.libraryapp.domain.Fruit;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FruitMemoryRepository implements FruitRepositoryV1 {
    private static Long id = 1L;
    private final List<Fruit> fruits;

    public FruitMemoryRepository() {
        fruits = new ArrayList<>();
    }

    @Override
    public Fruit createFruit(String name, LocalDate warehousingDate, Long price, boolean isSold) {
        Fruit fruit = new Fruit(id++, name, warehousingDate, price, isSold);
        fruits.add(fruit);
        return fruit;
    }

    @Override
    public void updateFruit(Long id) {
        for (Fruit fruit : fruits) {
            if (fruit.getId().equals(id)) {
                fruit.setIsSold(true);
                break;
            }
        }
    }

    @Override
    public List<Fruit> getFruits(String name) {
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals(name)) {
                result.add(fruit);
            }
        }
        return result;
    }
}
