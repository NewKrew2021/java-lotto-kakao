package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements GenerateStrategy {

    @Override
    public LottoNumbers generate() {
        return generateRandomNumbers();
    }

    private LottoNumbers generateRandomNumbers() {
        return new LottoNumbers(toTreeSet(sliceNumbers(shuffleNumbers())));
    }

    private List<LottoNumber> shuffleNumbers() {
        List<LottoNumber> numbers = IntStream
                .rangeClosed(LottoNumber.MIN_LOTTO_NUMBER,LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers;
    }

    private List<LottoNumber> sliceNumbers(List<LottoNumber> numbers) {
        return numbers.subList(0, LottoNumbers.POSSIBLE_NUMBERS_SIZE);
    }

    private Set<LottoNumber> toTreeSet(List<LottoNumber> numbers) {
        return new TreeSet(numbers);
    }

}