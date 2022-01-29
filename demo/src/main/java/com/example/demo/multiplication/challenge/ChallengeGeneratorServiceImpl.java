package com.example.demo.multiplication.challenge;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService{
    private final Random random;

    private final static int MINIMUM_FACTOR = 11;
    private final static int MAXIMUM_FACTOR = 100;

    ChallengeGeneratorServiceImpl(){
        this.random = new Random();
    }

    protected ChallengeGeneratorServiceImpl(final Random random){
        this.random =  random;
    }

    private int next(){
        return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
    }

    public Challenge randomChallenge(){
        return new Challenge(next(), next());
    }

}
