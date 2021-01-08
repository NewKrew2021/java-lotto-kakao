package lotto.controller;

import lotto.service.LottoReviewService;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WonLotto;
import lotto.service.LottoGeneratorService;
import lotto.view.LottoOutputView;

import java.util.Scanner;

public class LottoController {

    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
    private final Scanner scanner = new Scanner(System.in);

    public void lottoController() {

        Lottos lottos = buyLotto();
        lottoOutputView.printLottos(lottos);
        lottoOutputView.printInputWonlottoPhrase();
        Lotto lotto = lottoGeneratorService.lottoStringParser(getWonLotto());
        lottoOutputView.printInputBonusBallPhrase();
        int bonusBall = getBonusBall();
        WonLotto wonLotto = new WonLotto(lotto, bonusBall);
        lottoOutputView.printInputWonlottoPhrase();

        lottoOutputView.printSameCountPhrase(lottos.lottosRankingResult(lottos.lottosResult(wonLotto)));
        lottoOutputView.printProfitRatio(new LottoReviewService().getProfitRatio(lottos.lottosResult(wonLotto)));

    }


    public Lottos buyLotto() {

        lottoOutputView.printInputMoneyPhrase();
        int amount =getLottoBuyAmount();
        int buyCount = amount / 1000;
        lottoOutputView.printInputQuantityPhrase(buyCount);
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount / 1000; i++) {
            lottos.add(lottoGeneratorService.generateLotto());
        }
        return lottos;
    }

    public int getLottoBuyAmount() {
        int amount = Integer.parseInt(scanner.nextLine());
        return amount;
    }

    public String getWonLotto() {
        String wonLotto = scanner.nextLine();
        return wonLotto;
    }

    public int getBonusBall() {
        int bonusBall = Integer.parseInt(scanner.nextLine());
        return bonusBall;
    }
}
