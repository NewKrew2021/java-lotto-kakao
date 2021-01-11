package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerateStrategy implements LottoGenerateStrategy {

    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<String> lotto;

    public RandomLottoGenerateStrategy() {
        lotto = IntStream
                .rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .boxed()
                .map(number -> Integer.toString(number))
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> numberChooseStrategy() {
        Collections.shuffle(lotto);
        return lotto.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}
