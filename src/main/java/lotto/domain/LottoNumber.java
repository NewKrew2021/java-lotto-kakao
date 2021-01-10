package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private List<Number> numbers;
    private static final int BOUNDARY_START_NUMBER = 1;
    private static final int BOUNDARY_END_NUMBER = 45;
    private static final int LOTTO_BALL_NUMBER = 6;

    public LottoNumber() {
        numbers = IntStream.rangeClosed(BOUNDARY_START_NUMBER, BOUNDARY_END_NUMBER)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getRandomNumbers(){
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LOTTO_BALL_NUMBER)
                .collect(Collectors.toList());
    }
}
