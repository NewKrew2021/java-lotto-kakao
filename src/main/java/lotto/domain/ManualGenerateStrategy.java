package lotto.domain;

import lotto.utils.Splitter;
import lotto.view.InputView;

import java.util.List;

public class ManualGenerateStrategy implements GenerateStrategy {

    @Override
    public LottoNumbers generate() {
        return generateManually();
    }

    private LottoNumbers generateManually() {
        List<Integer> numbers = Splitter.splitToNumberBy(InputView.inputManualLotto(), ",");
        return new LottoNumbers(numbers);
    }
}
