package lotto.domain.ranking;

import java.util.function.Function;

public enum LottoBonusMatcher {
    TRUE(bonus -> bonus == true),
    FALSE(bonus -> bonus == false),
    DONTCARE(bonus -> true);

    private final Function<Boolean, Boolean> matchBonusAndRank;

    LottoBonusMatcher(Function<Boolean, Boolean> matchBonusAndRank) {
        this.matchBonusAndRank = matchBonusAndRank;
    }

    public boolean calculate(boolean bonus) {
        return matchBonusAndRank.apply(bonus);
    }
}