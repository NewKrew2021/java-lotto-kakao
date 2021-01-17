package lotto.view;

import lotto.domain.LottoDto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseList;
import lotto.domain.StatisticsResult;

import java.util.List;

public class LottoOutputView {

    private LottoDto lottoDto;

    public LottoOutputView(LottoDto lottoDto) {
        this.lottoDto = lottoDto;
    }

    public void printLottoTicketCount() {
        PurchaseList purchaseList = lottoDto.getPurchaseList();
        int manualLottoCount = purchaseList.getManualTicketCount();
        int autoLottoCount = purchaseList.getAutoTicketCount();
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "를 구매했습니다.");
    }

    public void printLottoTickets() {
        List<LottoTicket> lottoTickets = lottoDto.getLottoTickets();
        for( LottoTicket lottoTicket : lottoTickets ) {
            System.out.println(lottoTicket.toString());
        }
        System.out.println();
    }

    public void printWinningStatistics() {
        StatisticsResult statisticsResult = lottoDto.getStatisticsResult();
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println(statisticsResult.toString());
        System.out.println("총 수익률은 " + statisticsResult.getYield() + "입니다.");
    }

}
