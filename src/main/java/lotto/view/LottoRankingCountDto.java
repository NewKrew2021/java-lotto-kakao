package lotto.view;

import lotto.domain.ranking.LottoRanking;
import lotto.domain.ranking.LottoStatistics;

import java.util.Map;
import java.util.TreeMap;

public class LottoRankingCountDto {
    private final Map<LottoRanking, Long> rankingCount;

    private LottoRankingCountDto(Map<LottoRanking, Long> rankingCount) {
        Map<LottoRanking, Long> reversedRankingCount = new TreeMap<>(rankingCount).descendingMap();
        reversedRankingCount.remove(LottoRanking.NOTHING);
        this.rankingCount = reversedRankingCount;
    }

    public static LottoRankingCountDto from(LottoStatistics lottoRankingCount) {
        return new LottoRankingCountDto(lottoRankingCount.getRankingCount());
    }

    public Map<LottoRanking, Long> getRankingCount() {
        return rankingCount;
    }
}
