package com.example.msa.controller;

import com.example.msa.domain.Multiplication;
import com.example.msa.service.MultiplicationService;
import com.example.msa.service.MultiplicationServiceImpl;
import com.example.msa.service.RandomGeneratorService;
import com.example.msa.service.RandomGeneratorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationController.class)
class MultiplicationControllerTest {
    RandomGeneratorService randomGeneratorService = org.mockito.Mockito.mock(RandomGeneratorService.class);

    @MockBean
    private MultiplicationService multiplicationService = new MultiplicationServiceImpl(randomGeneratorService);


    private MockMvc mvc;

    private JacksonTester<Multiplication> json;

    @Before
    public void setUp(){
        JacksonTester.initFields(this, new ObjectMapper());
    }
    @Test
    public void getRandomMultiplicationTest() throws Exception{
        given(multiplicationService.createRandomMultiplication())
                .willReturn(new Multiplication(70,20));
        //when
        MockHttpServletResponse response = mvc.perform(
                get("/multiplications/random")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(json.write(new Multiplication(70,20)).getJson());
    }
}