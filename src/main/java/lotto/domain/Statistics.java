package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Statistics {
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;

    private final Rankings rankings;
    private static final List<Integer> prize = new ArrayList<>(Arrays.asList(ZERO, LottoReward.FIRST.getReward(),
            LottoReward.SECOND.getReward(),
            LottoReward.THIRD.getReward(),
            LottoReward.FOURTH.getReward(),
            LottoReward.FIFTH.getReward()));


    public Statistics(Map<Rank, Integer> rankingsMap) {
        rankings = new Rankings(rankingsMap);
    }

    public int getRank(Rank rank) {
        return rankings.getCountOfRank(rank);
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
        return (long) rankings.getCountOfRank(rank) * prize.get(rank.getRank());
    }

    public Rankings getRankings(){
        return rankings;
    }
}
