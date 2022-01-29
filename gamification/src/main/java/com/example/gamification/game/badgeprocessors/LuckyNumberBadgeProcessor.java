package com.example.gamification.game.badgeprocessors;

import com.example.gamification.challenge.ChallengeSolvedEvent;
import com.example.gamification.game.domain.BadgeType;
import com.example.gamification.game.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public class LuckyNumberBadgeProcessor implements BadgeProcessor{

    private static final int LUCKY_FACTOR = 42;

    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore, List<ScoreCard> scoreCardList, ChallengeSolvedEvent solved) {
        return solved.getFactorA() == LUCKY_FACTOR || solved.getFactorB() == LUCKY_FACTOR ?
                Optional.of(BadgeType.LUCKY_NUMBER) : Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.LUCKY_NUMBER;
    }
}
