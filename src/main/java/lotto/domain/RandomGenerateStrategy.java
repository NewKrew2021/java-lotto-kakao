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
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(numbers::add);
        Collections.shuffle(numbers);
        List<Integer> shuffledSubNumbers = numbers.subList(0, 6);
        Collections.sort(shuffledSubNumbers);
        return new LottoNumbers(shuffledSubNumbers);
    }
}