package lotto.domain;

import lotto.domain.result.LottoResult;

import java.util.List;

public class LottoSimulation {
    private final WinningLotto winningLotto;

    public LottoSimulation(String winningLottoText, String bonusBall) {
        this.winningLotto = WinningLotto.of(winningLottoText, bonusBall);
    }

    public List<LottoResult> match(Lottos lottos) {
        return lottos.match(winningLotto);
    }
}
