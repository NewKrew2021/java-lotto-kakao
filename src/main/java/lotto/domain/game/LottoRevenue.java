package lotto.domain.game;

import lotto.domain.ranking.LottoRankingCount;

public class LottoRevenue {

    private final long revenue;
    private final int totalTicketMoney;

    public LottoRevenue(long revenue, int totalTicketMoney) {
        this.revenue = revenue;
        this.totalTicketMoney = totalTicketMoney;

    }

    public static LottoRevenue of(LottoRankingCount lottoRankingCount, LottoGameCount lottoGameCount) {
        return new LottoRevenue(lottoRankingCount.calculateTotalPrice(), lottoGameCount.calculateTotalTicketMoney());
    }

    public double calculateRevenueRate() {
        return (double) revenue / (double) totalTicketMoney;
    }
}
