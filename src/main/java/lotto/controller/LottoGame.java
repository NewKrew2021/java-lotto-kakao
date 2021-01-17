package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoLogic;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGame {

    private LottoDto lottoDto;
    private LottoLogic lottoLogic;
    private LottoInputView lottoInputView;
    private LottoOutputView lottoOutputView;

    public LottoGame() {
        lottoDto = new LottoDto();
        lottoLogic = new LottoLogic(lottoDto);
        lottoInputView = new LottoInputView(lottoDto);
        lottoOutputView = new LottoOutputView(lottoDto);
    }

    public void run() {
        this.buyLottoTicket();                                      // 로또 티켓 구입 실행
        this.executePrintLottoTicket();                             // 로또 티켓 출력 실행
        this.winningLottoNumbers();                                 // 당첨 로또 번호 객체 생성
        this.confirmStatistics();                                   // 티켓의 당첨 여부 출력
    }

    private void buyLottoTicket() {
        lottoInputView.inputMoney();                                // 돈 입력
        lottoInputView.inputManualLottoBuying();                    // 수동 횟수 입력
        lottoInputView.inputManualLottoNumbers();                   // 수동 번호 입력
        lottoLogic.makePurchaseList();                              // 구매목록 객체 생성
        lottoLogic.buyLottoTickets();                               // 로또 티켓 구입
    }

    private void executePrintLottoTicket() {
        lottoOutputView.printLottoTicketCount();                    // 구입한 티켓 갯수출력
        lottoOutputView.printLottoTickets();                        // 구입한 티켓 출력
    }

    private void winningLottoNumbers() {
        lottoInputView.inputWinningLottoNumbers();                  // 당첨 로또 번호 입력
        lottoInputView.inputBonusNumber();                          // 로또 보너스 번호 입력
        lottoLogic.makeWinningLottoNumbers();                       // 당첨 로또 객체 생성
    }

    private void confirmStatistics() {
        lottoLogic.winningStatistics();                             // 구입한 티켓의 당첨여부 확인
        lottoOutputView.printWinningStatistics();                   // 결과 출력
    }

}
