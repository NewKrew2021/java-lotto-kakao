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

    public Map<Ranking, Integer> calculateLottoStatistics(WinnerNumbers winner) {
        Map<Ranking, Integer> statistics = new EnumMap<Ranking, Integer>(Ranking.class);
        for (Ranking value : Ranking.values()) {
            statistics.put(value, 0);
        }
        for (LottoNumbers numbers : tickets) {
            updateStatistics(statistics, numbers, winner);
        }
        return statistics;
    }

    private void updateStatistics(Map<Ranking, Integer> statistics, LottoNumbers numbers, WinnerNumbers winner) {
        Ranking rank = numbers.calculateRanking(winner);
        if (rank != null) {
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

}

