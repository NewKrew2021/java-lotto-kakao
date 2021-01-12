package lotto.domain.number;

import java.util.List;

public class ManualInputStrategy implements NumberGenerateStrategy {
    private final List<Integer> manualInputNumbers;

    public ManualInputStrategy(List<Integer> manualInputNumbers) {
        this.manualInputNumbers = manualInputNumbers;
    }

    @Override
    public List<Integer> generate() {
        return manualInputNumbers;
    }
}
