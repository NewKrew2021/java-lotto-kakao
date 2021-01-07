package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryUtil {
    public static final int LOTTERY_PRICE = 1000;
    static final String MSG_DUPLICATED_LOTTERYNUMBER = "로또 숫자는 중복될 수 없습니다.";
    static final int LOTTERY_NUMBER_SIZE = 6;
    static final String MSG_WRONG_LOTTERY_LENGTH = String.format(
            "로또 숫자의 길이는 %d이여야 합니다.", LOTTERY_NUMBER_SIZE);

    public static int calculateLotteryCount(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 0 이상이여야합니다.");
        }
        return money / LOTTERY_PRICE;
    }

    public static boolean isInvalidSizeLotteryNumbers(List<LotteryNumber> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_SIZE) {
            return true;
        }
        return false;
    }

    public static boolean isDuplicatedLotteryNumbers(List<LotteryNumber> numbers, LotteryNumber number) {
        if (numbers.contains(number)) {
            return true;
        }
        return isDuplicatedLotteryNumbers(numbers);
    }

    public static boolean isDuplicatedLotteryNumbers(List<LotteryNumber> numbers) {
        Set<LotteryNumber> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            return true;
        }
        return false;
    }
}
