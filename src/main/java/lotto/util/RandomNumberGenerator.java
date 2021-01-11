package lotto.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements LottoNumberGenerator {

    private static final int RANGE_MAX = 45;
    private static final int RANGE_MIN = 1;

    private static final List<Integer> lottoNumbers = IntStream
            .range(RANGE_MIN, RANGE_MAX + 1)
            .boxed()
            .collect(Collectors.toList());

    public List<Integer> getNumbers() {
        Collections.shuffle(lottoNumbers);
        return new ArrayList<>(lottoNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
