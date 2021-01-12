package lotto.view;

import lotto.domain.ranking.LottoRanking;
import lotto.domain.ranking.LottoRankingCount;

import java.util.Map;
import java.util.TreeMap;

public class LottoRankingCountDto {
    private final Map<LottoRanking, Integer> rankingCount;

    private LottoRankingCountDto(Map<LottoRanking, Integer> rankingCount) {
        Map<LottoRanking, Integer> reversedRankingCount = new TreeMap<>(rankingCount).descendingMap();
        reversedRankingCount.remove(LottoRanking.NOTHING);
        this.rankingCount = reversedRankingCount;
    }

    public static LottoRankingCountDto from(LottoRankingCount lottoRankingCount) {
        return new LottoRankingCountDto(lottoRankingCount.getRankingCount());
    }

    public Map<LottoRanking, Integer> getRankingCount() {
        return rankingCount;
    }

}
