package com.example.gamification.game.badgeprocessors;

import com.example.gamification.game.domain.BadgeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.NamingSecurityException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SilverBadgeProcessorTest {

    private SilverBadgeProcessor badgeProcessor;

    @BeforeEach
    public void setup(){
        badgeProcessor = new SilverBadgeProcessor();
    }

    @Test
    public void shouldGiveBadgeIfScoreOverTreshold(){
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(160, List.of(), null);
        assertThat(badgeType).contains(BadgeType.SILVER);
    }

    @Test
    public void shouldNotGiveIfScoreUnderThreshold(){
        Optional<BadgeType> badgeType = badgeProcessor
                .processForOptionalBadge(140, List.of(), null);
        assertThat(badgeType).isEmpty();
    }
}
