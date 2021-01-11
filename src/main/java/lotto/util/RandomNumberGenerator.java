package lotto.util;

import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements LottoNumberGenerator {

    private static final List<Integer> lottoNumbers = IntStream
            .range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
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
