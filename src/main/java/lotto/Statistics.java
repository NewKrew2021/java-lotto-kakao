package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Statistics {

    public static final int RANK_ONE = 2000000000;
    public static final int RANK_TWO = 30000000;
    public static final int RANK_THREE = 1500000;
    public static final int RANK_FOUR = 50000;
    public static final int RANK_FIVE = 5000;
    public static final int ZERO = 0;
    public static final int HUNDRED = 100;

    Map<Integer, Integer> rankings;
    List<Integer> prize;

    public Statistics(Map<Integer, Integer> rankings) {
        this.rankings = rankings;
    }

    public Statistics() {
        rankings = new TreeMap<>();
        prize = Arrays.asList(ZERO, RANK_ONE, RANK_TWO, RANK_THREE, RANK_FOUR, RANK_FIVE);
    }
    /*
    3개 일치 (5000원)- 1개
    4개 일치 (50000원)- 0개
    5개 일치 (1500000원)- 0개
    5개 일치, 보너스 볼 일치(30000000원) - 0개
    6개 일치 (2000000000원)- 0개
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("3개 일치 (5000원)- %d개\n", rankings.getOrDefault(5,ZERO)));
        sb.append(String.format("4개 일치 (50000원)- %d개\n", rankings.getOrDefault(4,ZERO)));
        sb.append(String.format("5개 일치 (1500000원)- %d개\n", rankings.getOrDefault(3,ZERO)));
        sb.append(String.format("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", rankings.getOrDefault(2,ZERO)));
        sb.append(String.format("6개 일치 (2000000000원)- %d개\n", rankings.getOrDefault(1, ZERO)));

        return sb.toString();
    }

    public void addRank(int rank) {
        rankings.put(rank, rankings.getOrDefault(rank, ZERO) + 1);
    }

    public int getRank(int rank) {
        return rankings.get(rank);
    }

    public int getProfitRate(int payMoney) {
        return (int) ((getProfitAmount() / (double) payMoney) * HUNDRED);
    }

    private long getProfitAmount() {
        long profitAmount = 0;
        for (int rank : rankings.keySet()) {
            profitAmount += prize.get(rank);
        }
        return profitAmount;
    }
}
