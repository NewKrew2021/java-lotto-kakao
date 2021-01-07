package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    private static final int LOTTERY_NUMBER_SIZE = 6;
    private static final String MSG_WRONG_LOTTERY_LENGTH = String.format(
            "로또 숫자의 길이는 %d이여야 합니다.", LOTTERY_NUMBER_SIZE);
    private static final String MSG_DUPLICATED_LOTTERYNUMBER = "로또 숫자는 중복될 수 없습니다.";

    private final List<LotteryNumber> numbers;

    public Lottery(List<LotteryNumber> numbers) {
        if (isInvalidSizeLotteryNumbers(numbers)) {
            throw new IllegalArgumentException(MSG_WRONG_LOTTERY_LENGTH);
        }
        if (isDuplicatedLotteryNumbers(numbers)) {
            throw new IllegalArgumentException(MSG_DUPLICATED_LOTTERYNUMBER);
        }
        this.numbers = numbers;
    }

    public static List<LotteryNumber> createRandomLotteryNumbers() {
        List<Integer> range_1_45 = IntStream.rangeClosed(LotteryNumber.MIN_LOTTERYNUMBER, LotteryNumber.MAX_LOTTERYNUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(range_1_45);
        return range_1_45.subList(0, LOTTERY_NUMBER_SIZE)
                .stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    private static boolean isDuplicatedLotteryNumbers(List<LotteryNumber> numbers) {
        Set<LotteryNumber> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            return true;
        }
        return false;
    }

    private static boolean isInvalidSizeLotteryNumbers(List<LotteryNumber> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_SIZE) {
            return true;
        }
        return false;
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
