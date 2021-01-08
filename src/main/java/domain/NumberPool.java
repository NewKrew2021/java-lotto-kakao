package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoConstant.LOTTO_MIN_NUMBER;
import static domain.LottoConstant.LOTTO_MAX_NUMBER;

public class NumberPool {
    private final List<Number> numbers;

    public NumberPool() {
        numbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .mapToObj(Number::getNumber)
                .collect(Collectors.toList());
    }

    public List<Number> getRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
