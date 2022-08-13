package com.example.msa.controller;

import com.example.msa.domain.Multiplication;
import com.example.msa.service.MultiplicationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
final class MultiplicationController {
    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService){
        this.multiplicationService = multiplicationService;
    }
    @GetMapping("/random")
    Multiplication getRandomMultiplicaion(){
        return multiplicationService.createRandomMultiplication();
    }
}
