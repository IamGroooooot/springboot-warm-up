package com.warmup.libraryapp.controller.fruit;

import com.warmup.libraryapp.domain.Fruit;
import com.warmup.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.warmup.libraryapp.dto.fruit.request.FruitSellRequest;
import com.warmup.libraryapp.dto.fruit.request.FruitStatRequest;
import com.warmup.libraryapp.dto.fruit.response.FruitCreateResponse;
import com.warmup.libraryapp.dto.fruit.response.FruitSellResponse;
import com.warmup.libraryapp.dto.fruit.response.FruitStatResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {
    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("")
    public FruitCreateResponse CreateFruit(@RequestBody FruitCreateRequest request) {
        String sql = "INSERT INTO fruit (name, warehousing_date, price) VALUES (?, ?, ?)";
        Fruit fruit = new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice(), false);
        jdbcTemplate.update(sql, fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice());
        return new FruitCreateResponse(fruit);
    }

    @PutMapping ("")
    public FruitSellResponse SellFruit(@RequestBody FruitSellRequest request) {
        String sql = "UPDATE fruit SET is_sold = true WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
        return new FruitSellResponse(request.getId());
    }

    @GetMapping("/stat")
    public FruitStatResponse GetFruitStat(FruitStatRequest request) {
        String sql = "SELECT name, warehousing_date, price, is_sold FROM fruit WHERE name = ?";
        List<Fruit> fruits = jdbcTemplate.query(sql, (rs, rowNum) -> new Fruit(
                rs.getString("name"),
                rs.getDate("warehousing_date").toLocalDate(),
                rs.getLong("price"),
                rs.getBoolean("is_sold")
        ), request.getName());

        long totalAmount = fruits.stream().mapToLong(Fruit::getPrice).sum();
        long salesAmount = fruits.stream().filter(Fruit::isSold).mapToLong(Fruit::getPrice).sum();
        long notSalseAmount = totalAmount - salesAmount;
        return new FruitStatResponse(salesAmount, notSalseAmount);
    }
}
