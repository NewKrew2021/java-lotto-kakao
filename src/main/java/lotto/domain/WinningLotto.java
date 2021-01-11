package lotto.domain;

import lotto.exception.BonusNumberException;

import java.util.List;

public class WinningLotto extends Lotto {

    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        if (lottoNumbers.contains(bonusNumber)) {
            throw new BonusNumberException();
        }
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public Rank getRankOfLotto(Lotto lotto) {
        return Rank.findRank(this.matchCount(lotto), lotto.contains(bonusNumber));
    }
}
