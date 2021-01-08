package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankingCount {
    private final Map<LottoRanking, Integer> rankingCount;

    private LottoRankingCount(Map<LottoRanking, Integer> rankingCount) {
        this.rankingCount = rankingCount;
    }

    public static LottoRankingCount of(List<LottoNumbers> lottoTickets , WinnerTicket winnerTicket){
        Map<LottoRanking, Integer> rankingCount = new HashMap<>();

        for (LottoNumbers lottoTicket : lottoTickets) {
            LottoRanking ranking = LottoRanking.find(winnerTicket.countMatchingNumber(lottoTicket),
                    winnerTicket.hasBonus(lottoTicket));
            rankingCount.compute(ranking, (rank, count) -> count == null ? 1 : count + 1);
        }
        return new LottoRankingCount(rankingCount);
    }

    public Map<LottoRanking, Integer> getRankingCount() {
        return rankingCount;
    }
}
