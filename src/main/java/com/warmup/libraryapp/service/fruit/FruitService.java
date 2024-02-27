package com.warmup.libraryapp.service.fruit;

import com.warmup.libraryapp.dto.fruit.request.*;
import com.warmup.libraryapp.dto.fruit.response.*;

import java.util.List;

public interface FruitService {
    FruitCreateResponse CreateFruit(FruitCreateRequest request);

    FruitSellResponse sellFruit(FruitSellRequest request);

    FruitStatResponse getFruitStat(FruitStatRequest request);

    FruitCountResponse getFruitCount(FruitCountRequest request);

    List<FruitListResponse> getFruitList(FruitListRequest request);
}
