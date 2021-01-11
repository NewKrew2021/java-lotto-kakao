package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;

import java.util.Set;

public class WinningLotto extends Lotto {
    public WinningLotto(Set<LottoNumber> LottoNumbers) {
        super(LottoNumbers);
    }

    public WinningLotto(LottoNumberGenerator lottoNumberGenerator) {
        super(lottoNumberGenerator);
    }

    public WinningLotto() {
        super(new RandomNumberGenerator());
    }

    public Rank getRankOfLotto(Lotto lotto, LottoNumber bonusNumber) {
        return Rank.checkRank(this.matchCount(lotto), lotto.isContain(bonusNumber));
    }
}
