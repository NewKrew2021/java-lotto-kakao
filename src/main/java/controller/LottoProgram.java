package controller;

import domain.*;
import exception.ManualLottoCountExceededException;
import exception.UnderLottoBuyAmountException;
import view.LottoProgramView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        int buyAutoLottoCount = calculateAutoBuyLottoCount(buyAmount, buyManualCount);
        Lottos lottos = new Lottos(makeAutoLottos(buyAutoLottoCount));

        lottoProgramView.printGetManualBallPhrase();
        addManualLottoToLottos(lottos, buyManualCount);

        lottoProgramView.printBoughtLottosCount(buyManualCount, buyAutoLottoCount);

        lottoProgramView.printLottosNumber(lottos);

        WinningLotto winningLotto = new WinningLotto(Ball.getBalls(lottoProgramView.getWinningLottoForUser())
                , lottoProgramView.getBonusBallForUser());

        LottoStatistics lottoStatistics = new LottoStatistics(lottos.getRankCounts(winningLotto), buyAmount);
        lottoProgramView.printWinningStatistics(lottoStatistics);
    }

    public void checkBuyAmount(int buyAmount) {
        if (buyAmount < Lotto.LOTTO_PRICE) {
            throw new UnderLottoBuyAmountException("구입 금액이 1000원 이상이어야 합니다.");
        }
    }

    public int calculateAutoBuyLottoCount(int buyAmount, int buyManualCount) {
        if (buyAmount < buyManualCount * Lotto.LOTTO_PRICE) {
            throw new ManualLottoCountExceededException("수동 구입 갯수가 초과하였습니다.");
        }
        return (buyAmount / Lotto.LOTTO_PRICE) - buyManualCount;
    }

    private void addManualLottoToLottos(Lottos lottos, int buyManualCount) {
        for (int i = 0; i < buyManualCount; i++) {
            lottos.addLotto(new Lotto(Ball.getBalls(lottoProgramView.getManualLottoForUser())));
        }
    }

    private List<Lotto> makeAutoLottos(int buyAutoLottoCount) {
        List<Lotto> autoLottos = new ArrayList<>();

        for (int i = 0; i < buyAutoLottoCount; i++) {
            autoLottos.add(new Lotto(RandomBallPool.getRandomBalls(Lotto.LOTTO_COUNT)));
        }
        return autoLottos;
    }
}
