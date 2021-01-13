package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseList;
import lotto.domain.StatisticsResult;
import lotto.domain.WinningLottoNos;
import lotto.service.LottoLogic;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private static final String WINNING_LOTTO_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MANUAL_LOTTO_INPUT_TEXT = "수동으로 구매할 번호를 입력해 주세요.";

    public void run() {
        List<LottoTicket> lottoTickets = LottoLogic.buyLottoTickets(this.createPurchaseList());           // 로또 티켓 구입
        LottoOutputView.printLottoTickets(lottoTickets);                                                        // 구입한 티켓 출력

        WinningLottoNos winningLottoNos =
                new WinningLottoNos(LottoInputView.inputLottoNumbers(WINNING_LOTTO_INPUT_TEXT), LottoInputView.inputBonusNumber());   // 당첨 로또 입력

        StatisticsResult statisticsResult = LottoLogic.winningStatistics(lottoTickets, winningLottoNos);        // 구입한 티켓의 당첨여부 확인

        LottoOutputView.printWinningStatistics(statisticsResult);                                               // 결과 출력
    }

    private PurchaseList createPurchaseList() {
        int money = LottoInputView.inputMoney();
        int manualTicketCount = LottoInputView.inputManualLottoBuying();
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++) {
            manualLottoNumbers.add(LottoInputView.inputLottoNumbers(MANUAL_LOTTO_INPUT_TEXT));
        }
        return new PurchaseList(money, manualLottoNumbers);
    }
}
