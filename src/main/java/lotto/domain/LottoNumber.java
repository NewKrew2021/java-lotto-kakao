package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private List<Number> numbers;
    private static final int BOUNDARY_START_NUM = 1;
    private static final int BOUNDARY_END_NUM = 46;

    public LottoNumber() {
        numbers = IntStream.range(BOUNDARY_START_NUM, BOUNDARY_END_NUM)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getRandomNumbers(){
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
