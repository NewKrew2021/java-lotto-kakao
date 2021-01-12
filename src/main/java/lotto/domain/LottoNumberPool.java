package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberPool {
    private static final List<Integer> lottoNumberPool =
            IntStream.rangeClosed(Ball.LOWER_BOUND, Ball.UPPER_BOUND).boxed().collect(Collectors.toList());

    public static List<Integer> autoGenerate() {
        Collections.shuffle(lottoNumberPool);
        return lottoNumberPool.subList(0, Lotto.COUNT_OF_NUMBERS);
    }
}
