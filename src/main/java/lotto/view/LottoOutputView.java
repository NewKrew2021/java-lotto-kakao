package lotto.view;

import lotto.domain.LottoNos;
import lotto.domain.StatisticsResult;

import java.util.List;

public class LottoOutputView {

    public static void printLottoCount(List<LottoNos> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for( LottoNos lottoTicket : lottoTickets ) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printWinningStatistics(StatisticsResult statisticsResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println(statisticsResult.toString());
        System.out.println(statisticsResult.benefit());
    }

}
