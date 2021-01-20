package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGame {

    private LottoService lottoService;
    private LottoInputView lottoInputView;
    private LottoOutputView lottoOutputView;

    public LottoGame() {
        lottoService = new LottoService();
        lottoInputView = new LottoInputView();
        lottoOutputView = new LottoOutputView();
    }

    public void run() {
        BuyingListDto buyingListDto = inputMoneyAndTicketCount();                       // 로또 티켓 구입 실행
        LottoDto lottoDto = executePrintLottoTicket(buyingListDto);         // 로또 티켓 출력 실행
        this.winningLottoNumbers(lottoDto);                                       // 당첨 로또 번호 객체 생성
        this.confirmStatistics(lottoDto);                                         // 티켓의 당첨 여부 출력
    }

    private BuyingListDto inputMoneyAndTicketCount() {
        BuyingListDto buyingListDto = new BuyingListDto();
        lottoInputView.inputMoney(buyingListDto);                                // 돈 입력
        lottoInputView.inputManualLottoBuying(buyingListDto);                    // 수동 횟수 입력
        lottoInputView.inputManualLottoNumbers(buyingListDto);                   // 수동 번호 입력
        lottoService.makePurchaseList(buyingListDto);                            // 구매목록 객체 생성
        return buyingListDto;

    }

    private LottoDto executePrintLottoTicket(BuyingListDto buyingListDto) {
        LottoDto lottoDto = new LottoDto();
        lottoService.buyLottoTickets(buyingListDto, lottoDto);             // 로또 티켓 구입
        lottoOutputView.printLottoTicketCount(buyingListDto);                    // 구입한 티켓 갯수출력
        lottoOutputView.printLottoTickets(lottoDto);                       // 구입한 티켓 출력
        return lottoDto;
    }

    private void winningLottoNumbers(LottoDto lottoDto) {
        lottoInputView.inputWinningLottoNumbers(lottoDto);                  // 당첨 로또 번호 입력
        lottoInputView.inputBonusNumber(lottoDto);                          // 로또 보너스 번호 입력
        lottoService.makeWinningLottoNumbers(lottoDto);                     // 당첨 로또 객체 생성
    }

    private void confirmStatistics(LottoDto lottoDto) {
        StatisticsResult statisticsResult = lottoService.winningStatistics(lottoDto);       // 구입한 티켓의 당첨여부 확인
        lottoOutputView.printWinningStatistics(statisticsResult);                                 // 결과 출력
    }

}
