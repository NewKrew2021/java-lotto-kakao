package lotto.domain;

import lotto.domain.result.LottoResults;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulation {
    private final Money price;
    private final WinningLotto winningLotto;
    private final Lottos lottos;

    public LottoSimulation(Money price, String winningLottoText, String bonusBall) {
        this.price = price;
        this.winningLotto = initWinningLotto(StringUtils.splitDigit(winningLottoText), bonusBall);
        this.lottos = Lottos.createRandomLottos(this.price.countLottoTicket());
    }

    private WinningLotto initWinningLotto(String[] lottoNumbers, String bonusBall) {
        List<Integer> lotto = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            lotto.add(StringUtils.parseInt(lottoNumber));
        }
        return WinningLotto.of(lotto, bonusBall);
    }

    public LottoResults match() {
        return LottoResults.of(lottos.match(winningLotto), price);
    }
}
