package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoReviewService;
import lotto.view.LottoOutputView;

import java.util.Scanner;

public class LottoController {

    private final LottoOutputView lottoOutputView;
    private final LottoGeneratorService lottoGeneratorService;
    private final Scanner scanner;

    public LottoController() {

        lottoGeneratorService = new LottoGeneratorService();
        lottoOutputView = new LottoOutputView();
        scanner = new Scanner(System.in);
    }

    public void startLottoGame() {

        Lottos lottos = buyLotto();
        lottoOutputView.printLottos(lottos);

        WonLotto wonLotto = createWonLotto();

        lottoOutputView.printSameCountPhrase(lottos.lottosRankingResult(lottos.lottosResult(wonLotto)));
        lottoOutputView.printProfitRatio(new LottoReviewService().getProfitRatio(lottos.lottosResult(wonLotto)));

    }


    public Lottos buyLotto() {

        lottoOutputView.printInputMoneyPhrase();
        Amount amount;
        do{
            amount=getLottoBuyAmount();
        }
        while (amount==null);
        lottoOutputView.printInputQuantityPhrase(amount.BuyCount());
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount.BuyCount(); i++) {
            lottos.add(lottoGeneratorService.generateLotto());
        }
        return lottos;
    }

    public WonLotto createWonLotto() {

        lottoOutputView.printInputWonlottoPhrase();
        Lotto lotto;
        while ((lotto = lottoGeneratorService.lottoStringParser(getWonLotto())) == null) {
            lottoOutputView.printInputErrorPhrase();
        }
        lottoOutputView.printInputBonusBallPhrase();
        LottoNumber bonusBall = getBonusBall();
        while (lotto.getLottoNumbers().contains(bonusBall)) {
            lottoOutputView.printInputDuplicatePhrase();
            bonusBall = getBonusBall();
        }
        return new WonLotto(lotto, bonusBall);
    }

    public Amount getLottoBuyAmount() {

        try {
            int money = Integer.parseInt(scanner.nextLine());
            return new Amount(money);
        } catch (Exception e) {
            lottoOutputView.printInputErrorPhrase();
            return null;
        }
    }

    public String getWonLotto() {

        String wonLotto = scanner.nextLine();
        return wonLotto;
    }

    public LottoNumber getBonusBall() {

        int bonusBall = Integer.parseInt(scanner.nextLine());
        return new LottoNumber(bonusBall);
    }

}
