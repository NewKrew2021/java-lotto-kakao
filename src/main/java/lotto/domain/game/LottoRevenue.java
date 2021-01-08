package lotto.domain.game;

import lotto.domain.ranking.LottoRankingCount;

public class LottoRevenue {

    private final long revenue;

    public LottoRevenue(long revenue) {
        this.revenue = revenue;
    }

    public static LottoRevenue from(LottoRankingCount lottoRankingCount) {
        return new LottoRevenue(lottoRankingCount.calculateTotalPrice());
    }

    public double calculateRevenueRate(LottoTicketCount lottoTicketCount) {
        int totalTicketMoney = lottoTicketCount.calculateTotalTicketMoney();
        return (double) revenue / totalTicketMoney;
    }

    public long getRevenue() {
        return revenue;
    }

}
