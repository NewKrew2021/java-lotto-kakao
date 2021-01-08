package lotto.domain.ranking;

import java.util.function.Function;

public enum LottoBonusApplicable {

    TRUE(bonus -> bonus == true),
    FALSE(bonus -> bonus == false),
    DONT_CARE(bonus -> true);

    private final Function<Boolean, Boolean> bonusMatching;

    LottoBonusApplicable(Function<Boolean, Boolean> bonusMatching) {
        this.bonusMatching = bonusMatching;
    }

    public boolean apply(boolean bonus) {
        return bonusMatching.apply(bonus);
    }
}
