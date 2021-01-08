package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public static final String MSG_DUPLICATED_LOTTERYNUMBER = "로또 숫자는 중복될 수 없습니다.";
    static final int LOTTERY_NUMBER_SIZE = 6;
    public static final String MSG_WRONG_LOTTERY_LENGTH = "로또 숫자의 길이는 6이여야 합니다.";

    private final List<LotteryNumber> numbers;

    public Lottery(int[] ints) {
        this(
                Arrays.stream(ints)
                        .mapToObj(LotteryNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public Lottery(List<LotteryNumber> numbers) {
        if (isInvalidSizeLotteryNumbers(numbers)) {
            throw new IllegalArgumentException(MSG_WRONG_LOTTERY_LENGTH);
        }
        if (isDuplicatedLotteryNumbers(numbers)) {
            throw new IllegalArgumentException(MSG_DUPLICATED_LOTTERYNUMBER);
        }
        this.numbers = numbers;
    }

    public static Lottery createRandomLottery() {
        List<Integer> range_1_45 = IntStream.rangeClosed(LotteryNumber.MIN_LOTTERYNUMBER, LotteryNumber.MAX_LOTTERYNUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(range_1_45);
        return new Lottery(
                range_1_45.subList(0, LOTTERY_NUMBER_SIZE)
                        .stream()
                        .map(LotteryNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public static boolean isDuplicatedLotteryNumbers(Lottery lottery, LotteryNumber bonusNumber) {
        if (lottery.numbers.contains(bonusNumber)) {
            return true;
        }
        return isDuplicatedLotteryNumbers(lottery.numbers);
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

    public LotteryPrize checkRank(LotteryAnswer lotteryAnswer) {
        boolean bonus = numbers.contains(lotteryAnswer.getBonusNumber());
        int count = (int) lotteryAnswer.getLottery()
                .numbers
                .stream()
                .filter(numbers::contains)
                .count();
        return LotteryUtil.convertCountToRank(count, bonus);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(LotteryNumber::toString)
                .collect(Collectors.joining(", ")) +
                "]";
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
