package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WonLotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoReviewService;
import lotto.view.LottoView;

import java.util.Scanner;

public class LottoController {

    private final LottoView lottoView = new LottoView();
    private final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
    private final Scanner scanner = new Scanner(System.in);
    private final int LOTTO_PRICE = 1000;


    public void lottoController() {

        Lottos lottos = buyLotto();
        lottoView.printLottos(lottos);

        WonLotto wonLotto = createWonLotto();

        lottoView.printSameCountPhrase(lottos.lottosRankingResult(lottos.lottosResult(wonLotto)));
        lottoView.printProfitRatio(new LottoReviewService().getProfitRatio(lottos.lottosResult(wonLotto)));

    }


    public Lottos buyLotto() {

        lottoView.printInputMoneyPhrase();
        int amount;
        while ((amount = getLottoBuyAmount()) == -1) ;
        int buyCount = amount / LOTTO_PRICE;
        lottoView.printInputQuantityPhrase(buyCount);
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount / LOTTO_PRICE; i++) {
            lottos.add(lottoGeneratorService.generateLotto());
        }
        return lottos;
    }

    public WonLotto createWonLotto() {

        lottoView.printInputWonlottoPhrase();
        Lotto lotto;
        while ((lotto = lottoGeneratorService.lottoStringParser(getWonLotto())) == null) {
            lottoView.printInputErrorPhrase();
        }
        lottoView.printInputBonusBallPhrase();
        int bonusBall = getBonusBall();
        while (lotto.getLotto().contains(bonusBall)) {
            lottoView.printInputDuplicatePhrase();
            bonusBall = getBonusBall();
        }
        return new WonLotto(lotto, bonusBall);
    }

    public int getLottoBuyAmount() {

        try {
            int amount = Integer.parseInt(scanner.nextLine());
            return validateLottoBuyAmount(amount);
        } catch (Exception e) {
            lottoView.printInputErrorPhrase();
            return -1;
        }
    }

    public String getWonLotto() {

        String wonLotto = scanner.nextLine();
        return wonLotto;
    }

    public int getBonusBall() {

        int bonusBall = Integer.parseInt(scanner.nextLine());
        return bonusBall;
    }


    public int validateLottoBuyAmount(int amount) {
        if (amount == 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("잘못된 입력금액입니다.");
        }
        return amount;
    }
}
