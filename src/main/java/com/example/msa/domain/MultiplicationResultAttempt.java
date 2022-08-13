package com.example.msa.domain;

import com.example.msa.domain.Multiplication;
import com.example.msa.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationResultAttempt {
    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    MultiplicationResultAttempt(){
        user = null;
        multiplication = null;
        resultAttempt = -1;
    }
}
