package domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {
    int END_LOTTO_NUMBER = 45;
    int START_LOTTO_NUMBER = 1;
    int LOTTO_NUMBER_SIZE = 6;

    List<Integer> numberChooseStrategy();
}
