package domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerateStrategy implements LottoGenerateStrategy{
    private final List<String> lotto;

    public ManualLottoGenerateStrategy(List<String> lotto) {
        this.lotto = lotto;
    }

    @Override
    public List<Integer> numberChooseStrategy() {
        return lotto.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
