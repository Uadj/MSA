package com.example.msa;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

class MultiplicationServiceImplTest {

//    @Mock
//    private RandomGeneratorService randomGeneratorService = new RandomGeneratorServiceImpl();

    RandomGeneratorService randomGeneratorService = org.mockito.Mockito.mock(RandomGeneratorService.class);
    private MultiplicationServiceImpl multiplicationServiceImpl  = new MultiplicationServiceImpl(randomGeneratorService);;

    @Test
    public void createRandomMultiplicationTest(){
        when(randomGeneratorService.generateRandomFactor()).thenReturn(50,30);
        given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);

        Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        assertThat(multiplication.getResult()).isEqualTo(1500);
    }
}