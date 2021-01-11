package lotto.domain;

import java.util.*;

public class Statistics {
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;

    private final Map<Rank, Integer> rankings;

    private static final List<Integer> prize = new ArrayList<>(Arrays.asList(ZERO, Rank.FIRST.getReward(),
            Rank.SECOND.getReward(),
            Rank.THIRD.getReward(),
            Rank.FOURTH.getReward(),
            Rank.FIFTH.getReward()));


    public Statistics(Map<Rank, Integer> rankingsMap) {
        this.rankings = Collections.unmodifiableMap(rankingsMap);

    }

    public int getCountOfRank(Rank rank) {
        return rankings.getOrDefault(rank, ZERO);
    }

    public int getProfitRate(Money money) {
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
