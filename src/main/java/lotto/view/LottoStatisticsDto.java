package lotto.view;

import lotto.domain.ranking.LottoRanking;
import lotto.domain.ranking.LottoStatistics;

import java.util.Map;
import java.util.TreeMap;

public class LottoStatisticsDto {
    private final Map<LottoRanking, Long> rankingCount;

    private LottoStatisticsDto(Map<LottoRanking, Long> rankingCount) {
        Map<LottoRanking, Long> reversedRankingCount = new TreeMap<>(rankingCount).descendingMap();
        reversedRankingCount.remove(LottoRanking.NOTHING);
        this.rankingCount = reversedRankingCount;
    }

    public static LottoStatisticsDto from(LottoStatistics lottoRankingCount) {
        return new LottoStatisticsDto(lottoRankingCount.getRankingCount());
    }

    public Map<LottoRanking, Long> getRankingCount() {
        return rankingCount;
    }
}
