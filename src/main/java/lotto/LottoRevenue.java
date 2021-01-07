package lotto;

import java.util.Map;

public class LottoRevenue {
    private final long revenue;

    public LottoRevenue(Map<LottoRanking, Integer> rankingCount) {
        long revenue = 0;

        for (Map.Entry<LottoRanking, Integer> entry : rankingCount.entrySet()) {
            revenue += entry.getKey().earnPrice(entry.getValue());
        }

        this.revenue = revenue;
    }

    public long getRevenue() {
        return revenue;
    }

}
