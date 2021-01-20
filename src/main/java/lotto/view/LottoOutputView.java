package lotto.view;

import lotto.domain.*;
import lotto.dto.BuyingListDto;
import lotto.dto.LottoDto;

import java.util.List;

public class LottoOutputView {

    public void printLottoTicketCount(BuyingListDto buyingListDto) {
        BuyingList buyingList = buyingListDto.getBuyingList();
        int manualLottoCount = buyingList.getManualTicketCount();
        int autoLottoCount = buyingList.getAutoTicketCount();
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "를 구매했습니다.");
    }

    public void printLottoTickets(LottoDto lottoDto) {
        List<LottoTicket> lottoTickets = lottoDto.getLottoTickets();
        for( LottoTicket lottoTicket : lottoTickets ) {
            System.out.println(lottoTicket.toString());
        }
        System.out.println();
    }

    public void printWinningStatistics(StatisticsResult statisticsResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println(statisticsResult.toString());
        System.out.println("총 수익률은 " + statisticsResult.getYield() + "입니다.");
    }

}
