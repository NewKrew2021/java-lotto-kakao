package lotto.domain;

import lotto.util.Prize;
import lotto.util.Rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rankings {
    private Map<Rank, Integer> rankings;

    private Rankings(Map<Rank, Integer> rankings) {
        this.rankings = Collections.unmodifiableMap(rankings);
    }

    public static Rankings fromRanks(List<Rank> ranks) {
        Map<Rank, Integer> rankMap = getInitialMap();

        for (Rank rank : ranks) {
            rankMap.compute(rank, (k, v) -> v + 1);
        }
        return new Rankings(rankMap);
    }

    private static Map<Rank, Integer> getInitialMap() {
        Map<Rank, Integer> rankMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, 0);
        }
        return rankMap;
    }

    public int getProfitRate(Money money) {
        return (int) ((getProfitAmount() / (double) money.getMoney()) * 100);
    }

    private long getProfitAmount() {
        int sum = 0;
        for (Rank rank : Rank.values()) {
            sum += getProfitAmountPerRank(rank);
        }
        return sum;
    }

    private long getProfitAmountPerRank(Rank rank) {
        return (long) rankings.get(rank) * Prize.getPrize(rank);
    }

    public Map<Rank, Integer> getRankings() {
        return rankings;
    }
}
