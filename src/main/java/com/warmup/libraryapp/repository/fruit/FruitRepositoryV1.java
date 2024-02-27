package com.warmup.libraryapp.repository.fruit;

import com.warmup.libraryapp.domain.Fruit;

import java.time.LocalDate;
import java.util.List;

public interface FruitRepositoryV1 {
    Fruit createFruit(String name, LocalDate warehousingDate, Long price, boolean isSold);

    void updateFruit(Long id);

    List<Fruit> getFruits(String name);
}
