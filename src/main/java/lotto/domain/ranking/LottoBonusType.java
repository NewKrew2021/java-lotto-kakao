package lotto.domain.ranking;

import java.util.function.Function;

public enum LottoBonusType {
    TRUE(bonus -> bonus == true),
    FALSE(bonus -> bonus == false),
    DONTCARE(bonus -> true);

    private final Function<Boolean, Boolean> bonusMatching;

    LottoBonusType(Function<Boolean, Boolean> bonusMatching) {
        this.bonusMatching = bonusMatching;
    }

    public boolean apply(boolean bonus) {
        return bonusMatching.apply(bonus);
    }
}
