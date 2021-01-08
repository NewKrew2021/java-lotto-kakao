package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

import java.util.Scanner;

public class ResultView {
    private static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    private static final String WINNING_RESULT = "당첨 통계\n----------------";

    private static Scanner sc = new Scanner(System.in);

    public static void purchaseLottoNumber(int price){
        System.out.println(price/1000 + PURCHASE_NUMBER);
    }

    public static void nextLine(){
        System.out.println();
    }

    public static void printResult(String result) {
        System.out.println();
        System.out.println(WINNING_RESULT);
        System.out.println(result);
    }

    public static void purchaseLottoTicket(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(val -> System.out.println(val.toString()));
        System.out.println();
    }
}
