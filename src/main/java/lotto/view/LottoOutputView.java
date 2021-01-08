package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.StatisticsResult;

import java.util.List;

public class LottoOutputView {

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for( LottoTicket lottoTicket : lottoTickets ) {
            System.out.println(lottoTicket.toString());
        }
        System.out.println();
    }

    public static void printWinningStatistics(StatisticsResult statisticsResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println(statisticsResult.toString());
        System.out.println("총 수익률은 " + statisticsResult.benefit() + "입니다.");
    }

}
