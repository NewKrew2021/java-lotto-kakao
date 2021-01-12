package lotto.domain;

import java.util.*;

public class Statistics {
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;

    private final Rankings rankings;
    private final Money money;

    public Statistics(Rankings rankings, Money money) {
        this.rankings = rankings;
        this.money = money;
    }

    public int getCountOfRank(Rank rank) {
        return rankings.getCountOfRank(rank);
    }

    public int getProfitRate() {
        return (int) ((getProfitAmount() / (double) money.getMoney()) * HUNDRED);
    }

    private long getProfitAmount() {
        return Rank.stream()
                .mapToLong(this::getProfitPerRank)
                .sum();
    }

    private long getProfitPerRank(Rank rank) {
        return (long) getCountOfRank(rank) * rank.getReward();
    }

}
