package lotto;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    private final List<LotteryNumber> numbers;
    private static final int LOTTERY_NUMBER_SIZE = 6;
    //1~45
    public Lottery(List<LotteryNumber> numbers){
        if(isInvalidSizeLotteryNumbers(numbers)){
            throw new IllegalArgumentException("로또 숫자의 길이는 6이여야 합니다.");
        }
        if (isDuplicatedLotteryNumbers(numbers)){
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }
        this.numbers = numbers;
    }

    public static List<LotteryNumber> createRandomLotteryNumbers(){
        List<Integer> range_1_45_45 = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(range_1_45_45);
        List<Integer> range_1_45_6 = range_1_45_45.subList(0,LOTTERY_NUMBER_SIZE);
        return range_1_45_6.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    private static boolean isDuplicatedLotteryNumbers(List<LotteryNumber> numbers){
        Set<LotteryNumber> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            return true;
        }
        return false;
    }

    private static boolean isInvalidSizeLotteryNumbers(List<LotteryNumber> numbers){
        if(numbers.size() != LOTTERY_NUMBER_SIZE){
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
