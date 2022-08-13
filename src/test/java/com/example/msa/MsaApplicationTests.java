package com.example.msa;

import com.example.msa.service.RandomGeneratorServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsaApplicationTests {

    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

    @Before
    public void setUp(){
        randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    }
    @Test
    void contextLoads() {
        System.out.println(randomGeneratorServiceImpl.generateRandomFactor());
    }


}
