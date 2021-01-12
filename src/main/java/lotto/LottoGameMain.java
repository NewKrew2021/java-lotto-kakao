package lotto;

import lotto.domain.LottoLogic;
import lotto.domain.LottoTicket;
import lotto.domain.StatisticsResult;
import lotto.domain.WinningLottoTicket;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        LottoGameMain lottoGameMain = new LottoGameMain();
        lottoGameMain.run();
    }

    public void run() {
        List<LottoTicket> lottoTickets = LottoLogic.buyLottoTicketsAuto(LottoInputView.inputMoney());           // 로또 티켓 구입
        LottoOutputView.printLottoTickets(lottoTickets);                                                        // 구입한 티켓 출력

        WinningLottoTicket winningLottoTicket =
                new WinningLottoTicket(LottoInputView.inputWinningNumbers(), LottoInputView.inputBonusNumber());   // 당첨 로또 입력

        StatisticsResult statisticsResult = LottoLogic.winningStatistics(lottoTickets, winningLottoTicket);        // 구입한 티켓의 당첨여부 확인

        LottoOutputView.printWinningStatistics(statisticsResult);                                               // 결과 출력
    }

}
