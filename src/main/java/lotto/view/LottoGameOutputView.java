package lotto.view;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;

import java.util.Scanner;

public class LottoGameOutputView {





    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getTicketCount() + "개를 구매했습니다.");
        System.out.println(lottoTickets);
    }





    public static void printResult(LottoResults lottoResults, int price) {
        System.out.println("당첨 통계");
        System.out.println("--------------");
        System.out.println(lottoResults);
        System.out.println("총 수익률은 " + lottoResults.calculateRate(price) + " 입니다.");
    }

}
