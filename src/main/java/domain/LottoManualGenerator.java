package domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoManualGenerator implements NumberGenerateStrategy {

    private List<Integer> numbers;

    public LottoManualGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generate() {
        Set<LottoNumber> numberSet = new TreeSet<>(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        return Lotto.from(numberSet);
    }
}
