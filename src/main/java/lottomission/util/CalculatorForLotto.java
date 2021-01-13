package lottomission.util;

import lottomission.domain.exception.InvalidMoneyException;
import lottomission.domain.exception.InvalidSumOfEarningMoneyException;

public class CalculatorForLotto {

    public float rateOfProfit(int usedMoney, int earnedMoney){
        if(isNotPositive(usedMoney)){
            throw new InvalidMoneyException();
        }
        if(isNegative(earnedMoney)){
            throw new InvalidSumOfEarningMoneyException();
        }
        return (float) earnedMoney / usedMoney;
    }

    private boolean isNotPositive(int value){
        return value <= 0;
    }

    private boolean isNegative(int value){
        return value < 0;
    }
}
