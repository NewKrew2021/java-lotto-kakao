package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements GenerateStrategy {

    @Override
    public LottoNumbers generate() {
        return generateRandomNumbers();
    }

    private LottoNumbers generateRandomNumbers() {
        return new LottoNumbers(sortNumbers(sliceNumbers(shuffleNumbers())));
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(numbers::add);
        Collections.shuffle(numbers);
        return numbers;
    }

    private List<Integer> sliceNumbers(List<Integer> numbers) {
        return numbers.subList(0, 6);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}