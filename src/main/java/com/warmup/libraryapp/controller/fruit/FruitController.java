package com.warmup.libraryapp.controller.fruit;

import com.warmup.libraryapp.dto.fruit.request.*;
import com.warmup.libraryapp.dto.fruit.response.*;
import com.warmup.libraryapp.service.fruit.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/count")
    public FruitCountResponse getFruitCount(FruitCountRequest request) {
        return fruitService.getFruitCount(request);
    }

    @GetMapping("/list")
    public List<FruitListResponse> getFruitList(FruitListRequest request) {
        System.out.println(request.getOption());
        System.out.println(request.getPrice());
        return fruitService.getFruitList(request);
    }
}
