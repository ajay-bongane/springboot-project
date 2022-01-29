package com.example.gamification.game.badgeprocessors;

import com.example.gamification.game.domain.BadgeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class GoldBadgeProcessorTest {
    private GoldBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setup(){
        badgeProcessor = new GoldBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfScoreOverThreshold(){
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(410, List.of(), null);
        assertThat(badgeType).contains(BadgeType.GOLD);
    }

    @Test
    public void shouldNotGiveIfScoreUnderThreshold(){
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(390, List.of(), null);
        assertThat(badgeType).isEmpty();
    }
}
