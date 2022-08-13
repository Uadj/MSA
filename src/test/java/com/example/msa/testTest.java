package com.example.msa;


import com.example.msa.service.RandomGeneratorServiceImpl;
import org.junit.jupiter.api.Test;

class testTest {
    private RandomGeneratorServiceImpl randomGeneratorService = new RandomGeneratorServiceImpl();

    @Test
    public void test12(){
        System.out.println(randomGeneratorService.generateRandomFactor());
    }

}