package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WonLotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoReviewService;
import lotto.view.LottoOutputView;

import java.util.Scanner;

public class LottoController {

    private final LottoOutputView lottoOutputView;
    private final LottoGeneratorService lottoGeneratorService;
    private final Scanner scanner;
    private final int LOTTO_PRICE = 1000;

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
        int amount;
        while ((amount = getLottoBuyAmount()) == -1) ;
        int buyCount = amount / LOTTO_PRICE;
        lottoOutputView.printInputQuantityPhrase(buyCount);
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount / LOTTO_PRICE; i++) {
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

    public int getLottoBuyAmount() {

        try {
            int amount = Integer.parseInt(scanner.nextLine());
            return validateLottoBuyAmount(amount);
        } catch (Exception e) {
            lottoOutputView.printInputErrorPhrase();
            return -1;
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


    public int validateLottoBuyAmount(int amount) {
        if (amount< 1000) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }
        return amount;
    }
}
