package lotto.domain.ranking;

import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankingCount {
    private final Map<LottoRanking, Integer> rankingCount;

    public LottoRankingCount(Map<LottoRanking, Integer> rankingCount) {
        this.rankingCount = rankingCount;
    }

    public static LottoRankingCount of(List<LottoNumbers> lottoTickets, WinnerTicket winnerTicket) {
        Map<LottoRanking, Integer> rankingCount = new HashMap<>();

        for (LottoRanking ranking : LottoRanking.values()) {
            rankingCount.put(ranking, 0);
        }
        for (LottoNumbers lottoTicket : lottoTickets) {
            LottoRanking ranking = LottoRanking.find(winnerTicket.countMatchingNumber(lottoTicket),
                    winnerTicket.hasBonus(lottoTicket));
            rankingCount.compute(ranking, (rank, count) -> count + 1);
        }
        return new LottoRankingCount(rankingCount);
    }

    public long calculateTotalPrice() {
        long totalPrice = 0;
        for (Map.Entry<LottoRanking, Integer> entry : rankingCount.entrySet()) {
            totalPrice += entry.getKey().earnPrice(entry.getValue());
        }
        return totalPrice;
    }

    public Map<LottoRanking, Integer> getRankingCount() {
        return rankingCount;
    }
}
