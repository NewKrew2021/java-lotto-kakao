package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPool {
    public static final int BALL_COUNT = 6;

    private static List<Number> numbers;

    static {
        numbers = IntStream.rangeClosed(Number.MIN_LOTTO_NUMBER, Number.MAX_LOTTO_NUMBER)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public static List<Number> getRandomNumbers(){
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(BALL_COUNT)
                .collect(Collectors.toList());
    }
}
