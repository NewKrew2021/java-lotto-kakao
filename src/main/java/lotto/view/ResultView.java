package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

import java.util.Map;
import java.util.Scanner;

public class ResultView {
    private static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    private static final String WINNING_RESULT = "\n당첨 통계\n----------------";

    private static Scanner sc = new Scanner(System.in);

    public static void purchaseLottoNumber(int price){
        System.out.println(price/1000 + PURCHASE_NUMBER);
    }

    public static void printResult(Map<LottoRank, Integer> result, int price) {
        ResultView resultView = new ResultView();
        System.out.println(WINNING_RESULT);

        System.out.println(resultView.matchResult(result));
        System.out.println(resultView.earningRate(result, price));
    }

    private String matchResult(Map<LottoRank, Integer> result) {
        String s = "";
        for (LottoRank rank : LottoRank.values()) {
            s += rank + " - " + result.get(rank) + "개\n";
        }
        return s;
    }

    private String earningRate(Map<LottoRank, Integer> result, int price) {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += result.get(rank) * rank.getPrice();
        }
        return "총 수익률은 " + (long) (sum / price * 100) + "%입니다.";
    }

    public static void purchaseLottoTicket(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(val -> System.out.println(val.toString()));
        System.out.println();
    }
}
