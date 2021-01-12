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

    public static int calculateProfitRate(int count, long total) {
        int input = (count * LotteryUtil.LOTTERY_PRICE);
        return (int) ((double) (total - input) / input * 100);
    }

    public static Lottery convertStringsToLottery(String[] strings) {
        return new Lottery(Arrays.stream(strings)
                .map(string -> LotteryNumber.of(Integer.parseInt(string.trim())))
                .collect(Collectors.toList()));
    }
}
