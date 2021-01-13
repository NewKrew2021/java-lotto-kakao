package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.StatisticsResult;
import lotto.domain.WinningLottoNos;
import lotto.service.LottoLogic;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoGame {
    public void run() {
        List<LottoTicket> lottoTickets = LottoLogic.buyLottoTicketsAuto(LottoInputView.inputMoney());           // 로또 티켓 구입
        LottoOutputView.printLottoTickets(lottoTickets);                                                        // 구입한 티켓 출력

        WinningLottoNos winningLottoNos =
                new WinningLottoNos(LottoInputView.inputWinningNumbers(), LottoInputView.inputBonusNumber());   // 당첨 로또 입력

        StatisticsResult statisticsResult = LottoLogic.winningStatistics(lottoTickets, winningLottoNos);        // 구입한 티켓의 당첨여부 확인

        LottoOutputView.printWinningStatistics(statisticsResult);                                               // 결과 출력
    }
}
