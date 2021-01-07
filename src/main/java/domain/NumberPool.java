package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPool {
    private List<Number> numbers;

    public NumberPool() {
        numbers = IntStream.range(1,46)
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
