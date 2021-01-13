package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.StatisticsResult;

import java.util.List;

public class LottoOutputView {

    public static void printLottoTicketCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "를 구매했습니다.");
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        for( LottoTicket lottoTicket : lottoTickets ) {
            System.out.println(lottoTicket.toString());
        }
        System.out.println();
    }

    public static void printWinningStatistics(StatisticsResult statisticsResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println(statisticsResult.toString());
        System.out.println("총 수익률은 " + statisticsResult.getYield() + "입니다.");
    }

}
