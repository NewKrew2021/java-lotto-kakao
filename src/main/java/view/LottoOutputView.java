package view;

import domain.Rank;
import dto.Amount;
import domain.WinningInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutputView {

    private static final String[] RESULT_FORMAT = {
            "3개 일치 (5000원) - %d개",
            "4개 일치 (50000원) - %d개",
            "5개 일치 (150000) - %d개",
            "5개 일치, 보너스 볼 일치(30000000원) - %d개",
            "6개 일치 (200000000원) - %d개"};


    public static void printTicketsCount(Amount amount) {
        StringBuilder sb = new StringBuilder();
        sb.append(amount.getCount()).append("개를 구매했습니다.");
        System.out.println(sb.toString());
    }

    public static void printResult(Map<Rank, Long> winningResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---------\n");
        for (Rank rank : Rank.values()) {
            appendResultMsg(winningResult, sb, rank);
        }
        System.out.println(sb);
    }

    private static void appendResultMsg(Map<Rank, Long> winningResult, StringBuilder sb, Rank rank) {
        if (rank == Rank.NONE) {
            return;
        }
        sb.append(rank.getResultMsg())
                .append(winningResult.get(rank))
                .append("개\n");
    }

    public static void printYield(Amount amount, Long sum) {
        double yield = (double) sum / amount.getAmount();
        System.out.println(String.format("총 수익률은 %.2f입니다.", yield));
    }

    public static void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            printLottoTicket(lottoTicket);
        }
        System.out.println();
    }

    private static void printLottoTicket(List<Integer> lottoTicket) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(lottoTicket
                .stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(", "))).append("]");
        System.out.println(sb);
    }
}