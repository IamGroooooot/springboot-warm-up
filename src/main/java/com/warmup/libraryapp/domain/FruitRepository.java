package com.warmup.libraryapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findAllByName(String name);

    long countByName(String name);

    List<Fruit> findAllByPriceGreaterThanEqualAndIsSoldFalse(Long price);

    List<Fruit> findAllByPriceLessThanEqualAndIsSoldFalse(Long price);
}
