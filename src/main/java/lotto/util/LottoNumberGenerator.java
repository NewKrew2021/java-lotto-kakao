package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Set;

public interface LottoNumberGenerator {
    Set<LottoNumber> getNumbers();
}
