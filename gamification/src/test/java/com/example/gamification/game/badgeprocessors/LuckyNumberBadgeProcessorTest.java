package com.example.gamification.game.badgeprocessors;

import com.example.gamification.challenge.ChallengeSolvedEvent;
import com.example.gamification.game.domain.BadgeType;
import com.example.gamification.game.domain.ScoreCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyNumberBadgeProcessorTest {

    private LuckyNumberBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setup(){
        badgeProcessor = new LuckyNumberBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfFactorAContainsLuckyNumber(){
        ChallengeSolvedEvent challenge = new ChallengeSolvedEvent(1L,
                true,
                42,43,
                1L,
                "ajay");
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(10, List.of(new ScoreCard(1L, 1L)), challenge);
        assertThat(badgeType).contains(BadgeType.LUCKY_NUMBER);
    }

    @Test
    public void shouldGiveBadgeIfFactorBContainsLuckyNumber(){
        ChallengeSolvedEvent challenge = new ChallengeSolvedEvent(1L,
                true,
                43,42,
                1L,
                "ajay");
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(10, List.of(new ScoreCard(1L, 1L)), challenge);
        assertThat(badgeType).contains(BadgeType.LUCKY_NUMBER);
    }

    @Test
    public void shouldGiveBadgeIfNoLuckyNumberInChallenge(){
        ChallengeSolvedEvent challenge = new ChallengeSolvedEvent(1L,
                true,
                43,43,
                1L,
                "ajay");
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(10, List.of(new ScoreCard(1L, 1L)), challenge);
        assertThat(badgeType).isEmpty();
    }
}
