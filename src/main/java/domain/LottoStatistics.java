package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {

    private final String RESULT_UNIT = "개\n";
    private final String EARNING_RATE_PREFIX = "총 수익률은 ";
    private final String EARNING_RATE_POSTFIX = "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private HashMap<LottoRank, Integer> rankCounts;
    private int buyAmount;

    public LottoStatistics(HashMap<LottoRank, Integer> rankCounts, int buyAmount) {
        this.rankCounts = rankCounts;
        this.buyAmount = buyAmount;
    }

    public long calculateTotalReward() {
        long totalReward = 0;

        for (LottoRank lottoRank : rankCounts.keySet()) {
           totalReward += rankCounts.get(lottoRank) * lottoRank.getReward();
        }

        return totalReward;
    }

    public double calculateEarningsRate(long buyAmount) {
        return calculateTotalReward() / buyAmount;
    }

    private void appendStatisticsResult(StringBuilder statisticsResult, LottoRank lottoRank){
        statisticsResult.append(lottoRank.getResultPrefix());
        statisticsResult.append(rankCounts.containsKey(lottoRank) ? rankCounts.get(lottoRank) : 0);
        statisticsResult.append(RESULT_UNIT);
    }

    @Override
    public String toString() {
        StringBuilder statisticsResult = new StringBuilder();

        List<LottoRank> printRanks = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.NONE))
                .collect(Collectors.toList());

        for(LottoRank lottoRank : printRanks){
            appendStatisticsResult(statisticsResult,lottoRank);
        }

        statisticsResult.append(EARNING_RATE_PREFIX);
        statisticsResult.append(calculateEarningsRate(buyAmount));
        statisticsResult.append(EARNING_RATE_POSTFIX);

        return statisticsResult.toString();
    }
}
