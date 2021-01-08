package lotto.domain.game;

import lotto.domain.ranking.LottoRankingCount;

public class LottoRevenue {
    private static final double PERCENT = 100.0;

    private final long revenue;

    public LottoRevenue(long revenue) {
        this.revenue = revenue;
    }

    public static LottoRevenue from(LottoRankingCount lottoRankingCount) {
        return new LottoRevenue(lottoRankingCount.calculateTotalPrice());
    }

    public double calculateRevenueRate(LottoGameCount lottoGameCount) {
        int totalTicketMoney = lottoGameCount.calculateTotalTicketMoney();
        return ((double) (revenue - totalTicketMoney) / totalTicketMoney) * PERCENT;
    }

    public long getRevenue() {
        return revenue;
    }

}
