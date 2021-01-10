package lotto.domain;

import lotto.domain.dto.LottoNumber;

import java.util.List;

public interface NumberPickStrategy {
    List<LottoNumber> generateLottoNumbers();
}
