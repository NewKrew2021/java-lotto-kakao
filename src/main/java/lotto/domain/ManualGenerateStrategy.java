package lotto.domain;

import lotto.utils.Splitter;
import lotto.view.InputView;

import java.util.Collections;
import java.util.List;

public class ManualGenerateStrategy implements GenerateStrategy {

    private static final String SPLIT_DELIMITER = ",";

    @Override
    public LottoNumbers generate() {
        return generateManualNumber();
    }

    private LottoNumbers generateManualNumber() {
        String manualLotto = InputView.scanManualLotto();
        List<Integer> sortedNumbers = sortNumbers(Splitter.splitToNumberBy(manualLotto, SPLIT_DELIMITER));
        return new LottoNumbers(sortedNumbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
