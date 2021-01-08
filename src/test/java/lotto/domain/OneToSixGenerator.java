package lotto.domain;

import lotto.domain.number.NumberGenerateStrategy;

import java.util.Arrays;
import java.util.List;

public class OneToSixGenerator implements NumberGenerateStrategy {
    @Override
    public List<Integer> generate() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
