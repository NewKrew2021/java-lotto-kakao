package lotto.domain;

import lotto.domain.vo.LottoNumber;

import java.util.List;

public interface NumberPickStrategy {
    List<LottoNumber> generateLottoNumbers();
}
