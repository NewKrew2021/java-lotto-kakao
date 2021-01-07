package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements GenerateStrategy {

    @Override
    public UserBuyNumbers generate() {
        return generateRandomNumbers();
    }

    private UserBuyNumbers generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(numbers::add);
        Collections.shuffle(numbers);
        List<Integer> shuffledSubNumbers = numbers.subList(0, 6);
        Collections.shuffle(shuffledSubNumbers);
        return new UserBuyNumbers(shuffledSubNumbers);
    }
}