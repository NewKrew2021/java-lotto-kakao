package lotto.domain;

import lotto.domain.vo.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberArray {
    public static List<LottoNumber> asList(int... parameters) {
        return Arrays.stream(parameters)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
