package lotto.domain;

import lotto.exception.InvalidLotteryNumberException;
import lotto.exception.InvalidMoneyException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LotteryUtil {
    public static final int LOTTERY_PRICE = 1000;

    public static int calculateLotteryCount(Money money) {
        if (Money.isInvalidMoneyValue(money)) {
            throw new InvalidMoneyException();
        }
        return money.getValue() / LOTTERY_PRICE;
    }

    public static int calculateProfitRate(int count, long total) {
        int input = (count * LotteryUtil.LOTTERY_PRICE);
        return (int) ((double) (total - input) / input * 100);
    }

    public static Lottery convertStringsToLottery(String[] strings) {
        try {
            return new Lottery(Arrays.stream(strings)
                    .map(string -> new LotteryNumber(Integer.parseInt(string.trim())))
                    .collect(Collectors.toList()));
        }catch (NumberFormatException e){
            throw new InvalidLotteryNumberException();
        }
    }

    public static LotteryPrize convertCountToRank(int count, boolean bonus) {
        return LotteryPrize.findRank(count,bonus);
    }
}
