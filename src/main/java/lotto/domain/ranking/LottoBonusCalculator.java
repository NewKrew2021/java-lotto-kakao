package lotto.domain.ranking;

import java.util.function.Function;

public enum LottoBonusCalculator {
    TRUE(bonus -> bonus == true),
    FALSE(bonus -> bonus == false),
    DONTCARE(bonus -> true);

    private final Function<Boolean, Boolean> matchBonusAndRank;

    LottoBonusCalculator(Function<Boolean, Boolean> matchBonusAndRank) {
        this.matchBonusAndRank = matchBonusAndRank;
    }

    public boolean calculate(boolean bonus) {
        return matchBonusAndRank.apply(bonus);
    }
}