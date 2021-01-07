package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Statistics {

    public static final int RANK_ONE = 2000000000;
    public static final int RANK_TWO = 30000000;
    public static final int RANK_THREE = 1500000;
    public static final int RANK_FOUR = 50000;
    public static final int RANK_FIVE = 5000;
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;

    Rankings rankings;
    List<Integer> prize;

    public Statistics(Map<Rank, Integer> rankingsMap) {
        for (Rank rank : Rank.values()) {
            rankingsMap.putIfAbsent(rank,0);
        }
        rankings = new Rankings(rankingsMap);
        prize = Arrays.asList(ZERO, RANK_ONE, RANK_TWO, RANK_THREE, RANK_FOUR, RANK_FIVE);
    }

    public Statistics() {
        rankings = new Rankings();
        prize = Arrays.asList(ZERO, RANK_ONE, RANK_TWO, RANK_THREE, RANK_FOUR, RANK_FIVE);
    }

    public void addRank(Rank rank) {
        rankings.addRank(rank);
    }

    public int getRank(Rank rank) {
        return rankings.getRank(rank);
    }

    public int getProfitRate(Money money) {
        return (int) ((getProfitAmount() / (double) money.getMoney()) * HUNDRED);
    }

    private long getProfitAmount() {
        return Rank.stream().mapToLong(this::getProfitPerRank).sum();
    }

    private long getProfitPerRank(Rank rank) {
        return (long) rankings.getRank(rank) * prize.get(rank.getRank());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("3개 일치 (5000원)- %d개\n", rankings.getRank(Rank.FIFTH)));
        sb.append(String.format("4개 일치 (50000원)- %d개\n", rankings.getRank(Rank.FOURTH)));
        sb.append(String.format("5개 일치 (1500000원)- %d개\n", rankings.getRank(Rank.THIRD)));
        sb.append(String.format("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", rankings.getRank(Rank.SECOND)));
        sb.append(String.format("6개 일치 (2000000000원)- %d개\n", rankings.getRank(Rank.FIRST)));

        return sb.toString();
    }
}
