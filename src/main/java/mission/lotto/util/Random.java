package mission.lotto.util;

import mission.lotto.domain.Lotto;
import mission.lotto.domain.Number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Random {

    private static final List<Integer> numberList;

    static {
        numberList = IntStream.range(Number.MIN_NUMBER_VALUE, Number.MAX_NUMBER_VALUE + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> getSixNumbers() {
        Collections.shuffle(numberList);
        return numberList.subList(0, Lotto.MAX_NUMBERS_LENGTH);
    }
}
