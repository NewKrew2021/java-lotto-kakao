package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    private static final String WINNING_RESULT = "\n당첨 통계\n----------------";
    private static final String EARNING_RATE = "총 수익률은 ";
    private static final String EARNING_RATE_SYMBOL = "%입니다.";
    private static final String TOTAL_LOTTO_TICKET = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";


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

    public static void purchaseLottoTicket(LottoTickets lottoTickets, List<String> handLotto) {
        System.out.printf(TOTAL_LOTTO_TICKET, handLotto.size(), lottoTickets.getLottoTickets().size()-handLotto.size());
        lottoTickets.getLottoTickets().forEach(val -> System.out.println(val.toString()));
        System.out.println();
    }
}
