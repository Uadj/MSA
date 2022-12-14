package com.example.msa.service;

import com.example.msa.domain.MultiplicationResultAttempt;
import com.example.msa.domain.Multiplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService){
        this.randomGeneratorService = randomGeneratorService;
    }
    @Override
    public Multiplication createRandomMultiplication(){
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt){
        return resultAttempt.getResultAttempt() ==
                resultAttempt.getMultiplication().getFactorA()*
                resultAttempt.getMultiplication().getFactorB();
    }
}
