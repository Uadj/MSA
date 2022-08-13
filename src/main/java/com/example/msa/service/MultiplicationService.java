package com.example.msa.service;

import com.example.msa.domain.MultiplicationResultAttempt;
import com.example.msa.domain.Multiplication;

public interface MultiplicationService {
    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
