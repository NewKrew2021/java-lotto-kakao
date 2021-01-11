package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public LottoStatistics calculateLottoStatistics(WinnerNumbers winner) {
        LottoStatistics statistics = new LottoStatistics();

        for (LottoNumbers numbers : tickets) {
            updateStatistics(statistics, numbers, winner);
        }
        return statistics;
    }

    private void updateStatistics(LottoStatistics statistics, LottoNumbers numbers, WinnerNumbers winner) {
        Ranking rank = numbers.calculateRanking(winner);
        if (rank != null) {
            statistics.addValue(rank, 1);
        }
    }

    public int getTicketsCount() {
        return tickets.size();
    }

    public String toString() {
        String result = "";
        for (LottoNumbers numbers : tickets) {
            result += numbers.toString() + "\n";
        }
        return result;
    }

}

