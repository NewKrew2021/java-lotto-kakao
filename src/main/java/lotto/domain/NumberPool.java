package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPool {
    public static final int BALL_COUNT = 6;

    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;

    private static NumberPool numberPool;
    private List<Number> numbers;

    private NumberPool() {
        numbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public static NumberPool getInstance() {
        if(numberPool == null) {
            numberPool = new NumberPool();
        }
        return numberPool;
    }

    public List<Number> getRandomNumbers(){
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(BALL_COUNT)
                .collect(Collectors.toList());
    }
}
