package lotto.view;

import lotto.domain.ranking.LottoRanking;
import lotto.domain.ranking.LottoStatistics;

import java.util.Map;
import java.util.TreeMap;

public class LottoStatisticsDto {

    private final Map<LottoRanking, Long> rankingCount;

    private LottoStatisticsDto(Map<LottoRanking, Long> rankingCount) {
        this.rankingCount = rankingCount;
    }

    public static LottoStatisticsDto from(LottoStatistics lottoStatistics) {
        Map<LottoRanking, Long> reversedRankingCount = new TreeMap<>(lottoStatistics.getRankingCount())
                .descendingMap();
        reversedRankingCount.remove(LottoRanking.NOTHING);
        return new LottoStatisticsDto(reversedRankingCount);
    }

    public Map<LottoRanking, Long> getRankingCount() {
        return rankingCount;
    }
}
