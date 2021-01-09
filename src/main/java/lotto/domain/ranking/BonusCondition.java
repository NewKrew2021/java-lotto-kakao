package lotto.domain.ranking;

import java.util.function.Function;

public enum BonusCondition {

    SHOULD_CONTAIN_BONUS(bonus -> bonus == true),
    NOT_CONTAIN_BONUS(bonus -> bonus == false),
    DONT_CARE(bonus -> true);

    private final Function<Boolean, Boolean> toBonusCondition;

    BonusCondition(Function<Boolean, Boolean> toBonusCondition) {
        this.toBonusCondition = toBonusCondition;
    }

    public boolean findConditionOf(boolean bonus) {
        return toBonusCondition.apply(bonus);
    }
}
