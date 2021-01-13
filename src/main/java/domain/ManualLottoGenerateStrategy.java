package domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerateStrategy implements LottoGenerateStrategy{
    private final List<Integer> lotto;

    public ManualLottoGenerateStrategy(List<String> lottos) {
        this.lotto = lottos.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> numberChooseStrategy() {
        return lotto;
    }
}
