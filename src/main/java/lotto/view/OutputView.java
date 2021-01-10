package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;

public class OutputView {
    public static void printLottoTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.print(lottoStatistics.toString());
    }

    public static void printEarningRatio(float earningRatio) {
        System.out.print("총 수익률은 " + earningRatio + "입니다.");
        if (earningRatio < 1)
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.toString());
    }
}
