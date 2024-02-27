package com.warmup.libraryapp.repository.fruit;

import com.warmup.libraryapp.domain.Fruit;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Primary
@Repository
public class FruitMySqlRepository implements FruitRepositoryV1 {
    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Fruit createFruit(String name, LocalDate warehousingDate, Long price, boolean isSold) {
        String sql = "INSERT INTO fruit (name, warehousing_date, price) VALUES (?, ?, ?)";
        Fruit fruit = new Fruit(name, warehousingDate, price, false);
        jdbcTemplate.update(sql, fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice());
        return fruit;
    }

    @Override
    public void updateFruit(Long id) {
        String sql = "UPDATE fruit SET is_sold = true WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Fruit> getFruits(String name) {
        String sql = "SELECT name, warehousing_date, price, is_sold FROM fruit WHERE name = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Fruit(
                rs.getString("name"),
                rs.getDate("warehousing_date").toLocalDate(),
                rs.getLong("price"),
                rs.getBoolean("is_sold")
        ), name);
    }
}
