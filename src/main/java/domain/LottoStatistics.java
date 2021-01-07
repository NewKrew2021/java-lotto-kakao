package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class LottoStatistics {

    private final String RESULT_UNIT = "개\n";
    private final String EARNING_RATE_PREFIX = "총 수익률은 ";
    private final String EARNING_RATE_POSTFIX = "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final HashMap<LottoRank, BigDecimal> rankNumbers;
    private BigDecimal buyAmount;

    public LottoStatistics(HashMap<LottoRank, BigDecimal> rankNumbers, int buyAmount) {
        this.rankNumbers = rankNumbers;
        this.buyAmount = new BigDecimal(String.valueOf(buyAmount));
    }

    public HashMap<LottoRank, BigDecimal> getRankNumbers() {
        return rankNumbers;
    }

    public BigDecimal calculateTotalReward() {
        BigDecimal totalReward = new BigDecimal("0");

        for (LottoRank lottoRank : rankNumbers.keySet()) {
            totalReward = totalReward.add(
                    lottoRank.getReward()
                            .multiply(rankNumbers.get(lottoRank)));
        }

        return totalReward;
    }

    public BigDecimal calculateEarningsRate(BigDecimal buyAmount) {
        return calculateTotalReward().divide(buyAmount, 2, RoundingMode.DOWN);
    }

    @Override
    public String toString() {
        StringBuilder statisticsResult = new StringBuilder();

        for (LottoRank lottoRank : LottoRank.values()) {
            statisticsResult.append(lottoRank.getResultPrefix());
            statisticsResult.append(rankNumbers.get(lottoRank));
            statisticsResult.append(RESULT_UNIT);
        }

        statisticsResult.append(EARNING_RATE_PREFIX);
        statisticsResult.append(calculateEarningsRate(buyAmount).doubleValue());
        statisticsResult.append(EARNING_RATE_POSTFIX);

        return statisticsResult.toString();
    }
}
