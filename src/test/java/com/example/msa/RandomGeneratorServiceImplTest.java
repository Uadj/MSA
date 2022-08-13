package com.example.msa;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorServiceImplTest {
    private RandomGeneratorServiceImpl randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();

    @Before
    public void setUp(){
        randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    }
    @Test
    public void generateRandomFactorIsBetweenExpectedLimits() throws Exception{
        List<Integer> randomFactors  = IntStream.range(0, 1000)
                .map(i -> randomGeneratorServiceImpl.generateRandomFactor())
                .boxed()
                .collect(Collectors.toList());
        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11,100)
                .boxed().collect(Collectors.toList()));
    }

}