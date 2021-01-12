package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements GenerateStrategy {

    private static final List<Integer> numbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER).forEach(numbers::add);
    }

    @Override
    public LottoNumbers generate() {
        return generateRandomNumbers();
    }

    private LottoNumbers generateRandomNumbers() {
        shuffleNumbers();
        return new LottoNumbers(sortNumbers());
    }

    private void shuffleNumbers() {
        Collections.shuffle(numbers);
    }

    private List<Integer> sortNumbers() {
        List<Integer> subNumbers = sliceNumbers();
        Collections.sort(subNumbers);
        return subNumbers;
    }

    private List<Integer> sliceNumbers() {
        return numbers.subList(0, LottoNumbers.POSSIBLE_NUMBERS_SIZE);
    }
}