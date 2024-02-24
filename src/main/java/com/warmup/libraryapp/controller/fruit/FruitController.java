package com.warmup.libraryapp.controller.fruit;

import com.warmup.libraryapp.dto.fruit.request.FruitCreateRequest;
import com.warmup.libraryapp.dto.fruit.request.FruitSellRequest;
import com.warmup.libraryapp.dto.fruit.request.FruitStatRequest;
import com.warmup.libraryapp.dto.fruit.response.FruitCreateResponse;
import com.warmup.libraryapp.dto.fruit.response.FruitSellResponse;
import com.warmup.libraryapp.dto.fruit.response.FruitStatResponse;
import com.warmup.libraryapp.service.fruit.FruitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("")
    public FruitCreateResponse createFruit(@RequestBody FruitCreateRequest request) {
        return fruitService.CreateFruit(request);
    }

    @PutMapping("")
    public FruitSellResponse sellFruit(@RequestBody FruitSellRequest request) {
        return fruitService.sellFruit(request);
    }

    @GetMapping("/stat")
    public FruitStatResponse getFruitStat(FruitStatRequest request) {
        return fruitService.getFruitStat(request);
    }
}
