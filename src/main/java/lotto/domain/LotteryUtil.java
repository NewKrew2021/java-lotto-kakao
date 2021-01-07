package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LotteryUtil {
    public static final int LOTTERY_PRICE = 1000;
    private static final int CHECK_BONUS = 1;
    private static final int NOT_CHECK_BONUS = 0;

    public static final int FIRST_PRIZE = 2000000000;
    public static final int SECOND_PRIZE = 30000000;
    public static final int THIRD_PRIZE = 1500000;
    public static final int FOURTH_PRIZE = 50000;
    public static final int FIFTH_PRIZE = 5000;

    public static final int[][] WINNING_TABLE = {
            {3, FIFTH_PRIZE, 5, NOT_CHECK_BONUS},
            {4, FOURTH_PRIZE, 4, NOT_CHECK_BONUS},
            {5, THIRD_PRIZE, 3, NOT_CHECK_BONUS},
            {5, SECOND_PRIZE, 2, CHECK_BONUS},
            {6, FIRST_PRIZE, 1, NOT_CHECK_BONUS}
    };

    public static final String[] WINNING_MSG = {
            WINNING_TABLE[0][0] + "개 일치 (" + WINNING_TABLE[0][1] + "원)-",
            WINNING_TABLE[1][0] + "개 일치 (" + WINNING_TABLE[1][1] + "원)-",
            WINNING_TABLE[2][0] + "개 일치 (" + WINNING_TABLE[2][1] + "원)-",
            WINNING_TABLE[3][0] + "개 일치, 보너스 볼 일치 (" + WINNING_TABLE[3][1] + "원)-",
            WINNING_TABLE[4][0] + "개 일치 (" + WINNING_TABLE[4][1] + "원)-"
    };

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
                .map(string -> new LotteryNumber(Integer.parseInt(string.trim())))
                .collect(Collectors.toList()));
    }

    public static int convertCountToRank(int count, boolean bonus) {
        for (int i = WINNING_TABLE.length - 1; i >= 0; i--) {
            if (WINNING_TABLE[i][0] == count && WINNING_TABLE[i][3] == CHECK_BONUS && bonus) {
                return WINNING_TABLE[i][2];
            }
            if (WINNING_TABLE[i][0] == count && WINNING_TABLE[i][3] == NOT_CHECK_BONUS) {
                return WINNING_TABLE[i][2];
            }
        }
        return Lottery.NONE;
    }
}
