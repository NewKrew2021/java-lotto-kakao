package lotto.domain;

import java.util.*;

public class Statistics {
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;

    private final Rankings rankings;
    private final Money money;

    private static final List<Integer> prize = new ArrayList<>(Arrays.asList(ZERO, Rank.FIRST.getReward(),
            Rank.SECOND.getReward(),
            Rank.THIRD.getReward(),
            Rank.FOURTH.getReward(),
            Rank.FIFTH.getReward()));

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
        return (long) getCountOfRank(rank) * prize.get(rank.getRank());
    }

}
