package lotto.utils;

import lotto.domain.dto.LottoNumber;

import java.util.List;

public interface NumberPickStrategy {
    List<LottoNumber> generateLottoNumbers();
}
