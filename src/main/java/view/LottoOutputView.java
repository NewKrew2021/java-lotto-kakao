package view;

import domain.LottoTicketCount;
import domain.Rank;
import dto.Amount;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoOutputView {

    public static void printTicketsCount(Amount amount) {
        StringBuilder sb = new StringBuilder();
        sb.append(amount.getCount()).append("개를 구매했습니다.");
        System.out.println(sb.toString());
    }

    public static void printTicketsCount(LottoTicketCount manualCount, LottoTicketCount autoCount) {
        System.out.println("수동으로 " + manualCount.getLottoTicketCount()
                + "장, 자동으로 " + autoCount.getLottoTicketCount() + "장을 구매했습니다.");
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

    public static void printYield(double yield) {
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