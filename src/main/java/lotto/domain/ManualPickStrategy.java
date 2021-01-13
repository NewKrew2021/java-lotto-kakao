package lotto.domain;

import lotto.domain.vo.LottoNumber;
import lotto.utils.NumbersSplitAndParser;

import java.util.List;
import java.util.stream.Collectors;

public class ManualPickStrategy implements NumberPickStrategy {
    private final List<String> ticketsNumbers;
    private int idx = 0;

    public ManualPickStrategy(List<String> ticketsNumbers) {
        this.ticketsNumbers = ticketsNumbers;
    }

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        List<Integer> numbers = NumbersSplitAndParser.parseToIntegers(ticketsNumbers.get(idx));
        consumeOne();

        return numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private void consumeOne() {
        idx++;
    }
}
