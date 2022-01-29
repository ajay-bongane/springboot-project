package com.example.gamification.game.badgeprocessors;

import com.example.gamification.game.domain.BadgeType;
import com.example.gamification.game.domain.ScoreCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstOneBadgeProcessorTest {
    private FirstWonBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setup(){
        badgeProcessor = new FirstWonBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfFirstTime(){
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(10, List.of(new ScoreCard(1L, 1L)),null);
        assertThat(badgeType).contains(BadgeType.FIRST_WON);
    }

    @Test
    public void shouldNotGiveBadgeIfNotFirstTime(){
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(
                        10,
                        List.of(
                                new ScoreCard(1L,1L),
                                new ScoreCard(1L, 2L)),
                        null);

        assertThat(badgeType).isEmpty();

    }
}
