package com.example.msa;

import com.example.msa.service.RandomGeneratorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
class RandomGeneratorServiceTest {

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Test
    public void generateRandomFactorIsBetweenExpectedLimists() throws Exception{
        List<Integer> randomFactors = IntStream.range(0,1000)
                .map(i -> randomGeneratorService.generateRandomFactor())
                .boxed()
                .collect(Collectors.toList());

        Assertions.assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11,100)
                .boxed()
                .collect(Collectors.toList()));
    }

}