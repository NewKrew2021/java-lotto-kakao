package lotto.domain;

import lotto.utils.Splitter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ManualGenerateStrategy implements GenerateStrategy {

    private static final String SPLIT_DELIMITER = ",";

    private final List<String> manualLottos;
    private int lottoIndex;

    public ManualGenerateStrategy(List<String> manualLottos) {
        this.manualLottos = manualLottos;
        this.lottoIndex = 0;
    }

    @Override
    public LottoNumbers generate() {
        return generateManualNumber();
    }

    private LottoNumbers generateManualNumber() {
        List<Integer> sortedNumbers = sortNumbers(
                Splitter.splitToNumberBy(manualLottos.get(lottoIndex++), SPLIT_DELIMITER)
        );
        return new LottoNumbers(sortedNumbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
