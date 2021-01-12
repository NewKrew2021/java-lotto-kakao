package domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {
    static final int END_LOTTO_NUMBER = 45;
    static final int START_LOTTO_NUMBER = 1;
    static final int LOTTO_NUMBER_SIZE = 6;

    List<Integer> numberChooseStrategy();
}
