package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(int count, List<LottoNumbers> tickets) {
        isValid(count, tickets);
        this.tickets = tickets;
    }

    private void isValid(int count, List<LottoNumbers> tickets) {
        if (tickets.size() != count)
            throw new IllegalArgumentException();
    }

    public LottoStat calculateLottoStatistics(WinnerNumbers winner) {
        LottoStat statistics = new LottoStat();

        for (LottoNumbers numbers : tickets) {
            updateStatistics(statistics, numbers, winner);
        }
        return statistics;
    }

    private void updateStatistics(LottoStat statistics, LottoNumbers numbers, WinnerNumbers winner) {
        Ranking rank = numbers.calculateRanking(winner);
        if (rank != null) {
            statistics.addValue(rank, 1);
        }
    }

}

