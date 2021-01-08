package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.List;

public interface NumberPickStrategy {
    List<LottoNumber> generateLottoNumbers();
}
