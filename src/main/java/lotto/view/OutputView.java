package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.dto.LottoStatisticDTO;

import java.util.List;

public class OutputView {

    public static void printLottoCount(LottoTickets lottoTicket, Money money) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", money.possibleNumberBuy() - lottoTicket.getAutoTicket().getTicket(), lottoTicket.getAutoTicket().getTicket());
    }

    public static void printBuyLotto(List<List<String>> numbers) {
        for (List<String> number : numbers) {
            System.out.println("[" + String.join(", ", number) + "]");
        }
        System.out.println();
    }

    public static void printManualInput() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printResult(LottoStatisticDTO lottoStatisticDTO) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        printRankCount(lottoStatisticDTO.getRankCount());
        printProfitRate(lottoStatisticDTO.getProfitRate());
    }

    private static void printRankCount(List<Integer> rankCount) {
        System.out.println("3개 일치 (5000원)- " + rankCount.get(1) + "개");
        System.out.println("4개 일치 (50000원)- " + rankCount.get(2) + "개");
        System.out.println("5개 일치 (1500000원)- " + rankCount.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + rankCount.get(4) + "개");
        System.out.println("6개 일치 (2000000000원)- " + rankCount.get(5) + "개");
    }

    private static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다.\n", profitRate);
    }
}
