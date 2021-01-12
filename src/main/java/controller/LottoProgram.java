package controller;

import domain.*;
import exception.ManualLottoCountExceededException;
import exception.UnderLottoBuyAmountException;
import view.LottoProgramView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoProgram {

    private LottoProgramView lottoProgramView;

    public LottoProgram() {
        lottoProgramView = new LottoProgramView();
    }

    public void start() {
        int buyAmount = lottoProgramView.getBuyAmountForUser();
        checkBuyAmount(buyAmount);

        int buyManualCount = lottoProgramView.getBuyManualLottoCountForUser();
        int buyAutoLottoCount = calculateAutoBuyLottoCount(buyAmount,buyManualCount);

        lottoProgramView.printGetManualBallPhrase();
        List<Lotto> manualLotto = getManualLottos(buyManualCount);

        lottoProgramView.printBoughtLottosCount(buyManualCount,buyAutoLottoCount);
        Lottos lottos = new Lottos(buyAutoLottoCount,manualLotto);

        lottoProgramView.printLottosNumber(lottos);

        WinningLotto winningLotto = new WinningLotto(lottoProgramView.getWinningLottoForUser()
                , lottoProgramView.getBonusBallForUser());

        LottoStatistics lottoStatistics = new LottoStatistics(lottos.getRankCounts(winningLotto),buyAmount);
        lottoProgramView.printWinningStatistics(lottoStatistics);
    }

    public void checkBuyAmount(int buyAmount) {
        if(buyAmount < Lotto.LOTTO_PRICE){
            throw new UnderLottoBuyAmountException("구입 금액이 1000원 이상이어야 합니다.");
        }
    }

    public int calculateAutoBuyLottoCount(int buyAmount, int buyManualCount) {
        if(buyAmount < buyManualCount * Lotto.LOTTO_PRICE){
            throw new ManualLottoCountExceededException("수동 구입 갯수가 초과하였습니다.");
        }
        return (buyAmount / Lotto.LOTTO_PRICE) - buyManualCount;
    }

    private List<Lotto> getManualLottos(int buyManualCount){
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < buyManualCount; i++) {
            manualLottos.add(new Lotto(getBalls(lottoProgramView.getManualLottoForUser())));
        }
        return manualLottos;
    }

    private List<Ball> getBalls(String[] numbers){
        return Arrays.stream(numbers)
                .map(Ball::new)
                .collect(Collectors.toList());
    }
}
