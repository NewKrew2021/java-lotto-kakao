package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberPool {
    private static NumberPool numberPool;
    private List<Number> numbers;

    private NumberPool() {
        numbers = IntStream.range(1,46)
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
                .limit(6)
                .collect(Collectors.toList());
    }
}
