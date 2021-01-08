package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.MatchNumber;
import lotto.domain.Money;
import lotto.domain.Rankings;
import lotto.dto.RankingsDto;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.LottoUI;

public class LottoController {
    private final LottoUI lottoUI;
    private final LottoNumberGenerator lottoNumberGenerator;
    private MatchNumber matchNumber;
    private Lottos lottos;
    private Money money;

    public LottoController() {
        lottoUI = new LottoUI();
        lottoNumberGenerator = new RandomNumberGenerator();
    }

    public void buyLotto() {
        money = new Money(lottoUI.getMoneyFromUser());
        lottos = Lottos.fromMoney(money, lottoNumberGenerator);
        lottoUI.printLottos(lottos);
    }

    public void getWinningNumber() {
        String winningNumberText = lottoUI.getWinningNumberFromUser();
        int bonusNumber = lottoUI.getBonusNumberFromUser();

        matchNumber = MatchNumber.of(winningNumberText, bonusNumber);
    }

    public void matchLotto() {
        RankingsDto rankingsDto = lottos.match(matchNumber);
        Rankings rankings = new Rankings(rankingsDto.getRankings());
        lottoUI.printStatistics(rankings.toString(), rankings.getProfitRate(money));
    }
}
