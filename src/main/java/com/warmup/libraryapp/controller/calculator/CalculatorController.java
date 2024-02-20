package com.warmup.libraryapp.controller.calculator;

import com.warmup.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.warmup.libraryapp.dto.calculator.request.CalculatorCalcRequest;
import com.warmup.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.warmup.libraryapp.dto.calculator.request.CalculatorSumRequest;
import com.warmup.libraryapp.dto.calculator.response.CalculatorCalcResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }

    @GetMapping("/api/v1/calc")
    public CalculatorCalcResponse calcTwoNumbers(CalculatorCalcRequest request) {
        CalculatorCalcResponse response = new CalculatorCalcResponse();
        response.setAdd(request.getNum1() + request.getNum2());
        response.setMinus(request.getNum1() - request.getNum2());
        response.setMultiply(request.getNum1() * request.getNum2());
        return response;
    }

    @PostMapping("/api/v1/sums")
    public int sumNumbers(@RequestBody CalculatorSumRequest request) {
        return request.getNumbers().stream().mapToInt(Integer::intValue).sum();
    }
}
