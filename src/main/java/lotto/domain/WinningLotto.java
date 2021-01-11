package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.List;
import java.util.Set;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> LottoNumbers) {
        super(LottoNumbers);
    }

    public WinningLotto(LottoNumberGenerator lottoNumberGenerator) {
        super(lottoNumberGenerator);
    }

    public WinningLotto() {
        super();
    }

    public Rank getRankOfLotto(Lotto lotto, LottoNumber bonusNumber) {
        return Rank.findRank(this.matchCount(lotto), lotto.contains(bonusNumber));
    }
}
