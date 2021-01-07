package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public static final int NONE = -1;

    private final List<LotteryNumber> numbers;

    public Lottery(int[] numbers) {
        this(Arrays.stream(numbers)
                .mapToObj(LotteryNumber::new)
                .collect(Collectors.toList()));
    }

    public Lottery(List<LotteryNumber> numbers) {
        if (LotteryUtil.isInvalidSizeLotteryNumbers(numbers)) {
            throw new IllegalArgumentException(LotteryUtil.MSG_WRONG_LOTTERY_LENGTH);
        }
        if (LotteryUtil.isDuplicatedLotteryNumbers(numbers)) {
            throw new IllegalArgumentException(LotteryUtil.MSG_DUPLICATED_LOTTERYNUMBER);
        }
        this.numbers = numbers;
    }

    public static List<LotteryNumber> createRandomLotteryNumbers() {
        List<Integer> range_1_45 = IntStream.rangeClosed(LotteryNumber.MIN_LOTTERYNUMBER, LotteryNumber.MAX_LOTTERYNUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(range_1_45);
        return range_1_45.subList(0, LotteryUtil.LOTTERY_NUMBER_SIZE)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    public int checkRank(LotteryAnswer lotteryAnswer) {
        boolean bonus = numbers.contains(lotteryAnswer.getBonusNumber());
        int count = (int) lotteryAnswer.getAnswerNumber()
                .stream()
                .filter(numbers::contains)
                .count();
        return convertCountToRank(count, bonus);
    }

    private int convertCountToRank(int count, boolean bonus) {
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
        return NONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(numbers, lottery.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
