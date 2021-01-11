package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.List;

public class WinningLotto extends Lotto {

    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> LottoNumbers, int bonusNumber) {
        super(LottoNumbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public WinningLotto(LottoNumberGenerator lottoNumberGenerator, int bonusNumber) {
        super(lottoNumberGenerator);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public Rank getRankOfLotto(Lotto lotto) {
        return Rank.findRank(this.matchCount(lotto), lotto.contains(bonusNumber));
    }
}
