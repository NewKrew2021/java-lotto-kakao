package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;

import java.util.Scanner;

public class ResultView {
    private static final String WINNING_RESULT = "\n당첨 통계\n----------------";
    private static final String EARNING_RATE = "총 수익률은 ";
    private static final String EARNING_RATE_SYMBOL = "%입니다.";


    private static Scanner sc = new Scanner(System.in);

    public static void printResult(LottoResults lottoResults, int price) {
        ResultView resultView = new ResultView();
        System.out.println(WINNING_RESULT);

        System.out.println(resultView.matchResult(lottoResults));
        System.out.println(EARNING_RATE + lottoResults.earningRate(price) + EARNING_RATE_SYMBOL);
    }

    private String matchResult(LottoResults lottoResults) {
        String s = "";
        for (LottoRank rank : LottoRank.values()) {
            s += rank + " - " + lottoResults.getCountLottoRank(rank) + "개\n";
        }
        return s;
    }

    public static void purchaseLottoTicket(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(val -> System.out.println(val.toString()));
        System.out.println();
    }
}
