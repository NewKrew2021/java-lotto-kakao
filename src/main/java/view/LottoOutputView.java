package view;

import domain.Amount;
import domain.WinningInfo;

import java.util.List;

public class LottoOutputView {


    private static final String[] RESULT_FORMAT = {"3개 일치 (5000원) - %d개",
            "4개 일치 (50000원) - %d개",
            "5개 일치 (150000) - %d개",
            "5개 일치, 보너스 볼 일치(30000000원) - %d개",
            "6개 일치 (200000000워원) - %d개"};


    public static void printTicketsCount(int ticketsCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(ticketsCount).append("개를 구매했습니다.");
        System.out.println(sb.toString());
    }

    public static void printResult(WinningInfo winningInfo) {
        String resultText = "당첨 통계\n---------\n";
        List<Integer> result = winningInfo.getWinningInfo();
        for (int i = 0; i < result.size(); i++) {
            resultText += String.format(RESULT_FORMAT[i], result.get(i)) + '\n';
        }
        System.out.println(resultText);
    }

    public static void printYield(Amount amount, Long sum) {
        double yield = (double) sum / amount.getAmount();
        System.out.println(String.format("총 수익률은 %.2f입니다.", yield));
    }
}