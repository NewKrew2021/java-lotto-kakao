package lotto;

public class LotteryUtil {
    public static final int LOTTERY_PRICE = 1000;

    public static int calculateLotteryCount(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 0 이상이여야합니다.");
        }
        return money / LOTTERY_PRICE;
    }
}
