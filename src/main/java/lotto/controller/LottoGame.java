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

    public void run() {
        PurchaseList purchaseList = this.createPurchaseList();
        List<LottoTicket> lottoTickets = LottoLogic.buyLottoTickets(purchaseList);           // 로또 티켓 구입
        LottoOutputView.printLottoTicketCount(purchaseList.getManualTicketCount(), purchaseList.getAutoTicketCount());                    // 구입한 티켓 갯 출력
        LottoOutputView.printLottoTickets(lottoTickets);                                                        // 구입한 티켓 출력

        WinningLottoNos winningLottoNos =
                new WinningLottoNos(LottoInputView.inputWinningLottoNumbers(), LottoInputView.inputBonusNumber());   // 당첨 로또 입력

        StatisticsResult statisticsResult = LottoLogic.winningStatistics(lottoTickets, winningLottoNos);        // 구입한 티켓의 당첨여부 확인

        LottoOutputView.printWinningStatistics(statisticsResult);                                               // 결과 출력
    }

    private PurchaseList createPurchaseList() {
        int money = LottoInputView.inputMoney();
        int manualTicketCount = LottoInputView.inputManualLottoBuying();
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++) {
            manualLottoNumbers.add(LottoInputView.inputManualLottoNumbers());
        }
        return new PurchaseList(money, manualLottoNumbers);
    }
}
