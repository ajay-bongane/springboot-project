package com.example.gamification.game.badgeprocessors;

import com.example.gamification.challenge.ChallengeSolvedEvent;
import com.example.gamification.game.domain.BadgeType;
import com.example.gamification.game.domain.ScoreCard;

import java.util.List;
import java.util.Optional;

public class SilverBadgeProcessor implements BadgeProcessor{

    private final int SCORE_THRESHOLD = 150;

    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore, List<ScoreCard> scoreCardList, ChallengeSolvedEvent solved) {
        return currentScore > SCORE_THRESHOLD ? Optional.of(BadgeType.SILVER) : Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.SILVER;
    }
}
