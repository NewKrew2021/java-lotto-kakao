package view;

import domain.LottoRank;
import domain.WinningInfo;
import java.util.List;
import java.util.Map;

public class LottoOutputView {

  private LottoOutputView() {
  }

  private static final String[] RESULT_FORMAT = {"3개 일치 (5000원) - %d개\n",
      "4개 일치 (50000원) - %d개\n",
      "5개 일치 (150000) - %d개\n",
      "5개 일치, 보너스 볼 일치(30000000원) - %d개\n",
      "6개 일치 (200000000워원) - %d개\n"};


  public static void printTicketsCount(int ticketsCount) {
    StringBuilder sb = new StringBuilder();
    sb.append(ticketsCount).append("개를 구매했습니다.");
    System.out.println(sb.toString());
  }

  public static void printTickets(List<List<Integer>> lottoTicketsInfo) {
    StringBuilder lottoTicketsText = new StringBuilder();
    for (List<Integer> lottoTicket : lottoTicketsInfo) {
      makeLottoTicketText(lottoTicketsText, lottoTicket);
    }
    System.out.println(lottoTicketsText);
  }

  private static void makeLottoTicketText(StringBuilder lottoTicketsText,
      List<Integer> lottoTicket) {
    lottoTicketsText.append("[");
    lottoTicketsText.append(lottoTicket.get(0));
    for (int i = 1; i < lottoTicket.size(); i++) {
      lottoTicketsText.append(", ");
      lottoTicketsText.append(lottoTicket.get(i));
    }
    lottoTicketsText.append("]\n");
  }

  public static void printResult(WinningInfo winningInfo) {
    StringBuilder resultText = new StringBuilder();
    resultText.append("당첨 통계\n---------\n");
    Map<LottoRank, Integer> result = winningInfo.getInfo();
    for (int i = 0; i < RESULT_FORMAT.length; i++) {
      resultText.append(String.format(RESULT_FORMAT[i],
          result.getOrDefault(LottoRank.of(RESULT_FORMAT.length - i), 0)));
    }
    System.out.println(resultText);
  }

  public static void printYield(double yield) {
    System.out.println(String.format("총 수익률은 %.2f입니다.", yield));
  }
}