package com.example.msa;

import com.example.msa.domain.Multiplication;
import com.example.msa.domain.MultiplicationResultAttempt;
import com.example.msa.domain.User;
import com.example.msa.service.MultiplicationServiceImpl;
import com.example.msa.service.RandomGeneratorService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
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
        //assertThat(multiplication.getResult()).isEqualTo(1500);
    }
    @Test
    public void checkCorrectAtteptTest(){
        Multiplication multiplication = new Multiplication(50,60);
        User user = new User("John_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000);

        boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

        assertThat(attemptResult).isTrue();
    }
    @Test
    public void checkWrongAtteptTest(){
        Multiplication multiplication = new Multiplication(50,60);
        User user = new User("John_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3010);

        boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

        assertThat(attemptResult).isFalse();
    }
}