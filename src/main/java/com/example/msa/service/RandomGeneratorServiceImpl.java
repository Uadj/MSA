package com.example.msa.service;

import com.example.msa.service.RandomGeneratorService;

import java.util.Random;

public class RandomGeneratorServiceImpl implements RandomGeneratorService {
    final static int MINIMUM_FACTOR = 11;
    final static int MAXIMUM_FACTOR = 99;
    public int generateRandomFactor(){
        return new Random().nextInt((MAXIMUM_FACTOR - MINIMUM_FACTOR)+1)+ MINIMUM_FACTOR;
    }
}
