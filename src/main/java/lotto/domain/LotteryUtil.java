package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LotteryUtil {
    public static final int LOTTERY_PRICE = 1000;

    public static int calculateLotteryCount(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 0 이상이여야합니다.");
        }
        return money / LOTTERY_PRICE;
    }

    public static Lottery convertStringsToLottery(String[] strings) {
        return new Lottery(Arrays.stream(strings)
                .map(string -> new LotteryNumber(Integer.parseInt(string)))
                .collect(Collectors.toList()));
    }

    public static int convertCountToRank(int count, boolean bonus) {
        if (count == 3) {
            return 5;
        }
        if (count == 4) {
            return 4;
        }
        if (count == 5 && bonus) {
            return 2;
        }
        if (count == 5) {
            return 3;
        }
        if (count == 6) {
            return 1;
        }
        return Lottery.NONE;
    }
}
