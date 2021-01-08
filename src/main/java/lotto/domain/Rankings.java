package lotto.domain;

import lotto.util.Prize;
import lotto.util.Rank;

import java.util.Collections;
import java.util.Map;

public class Rankings {
    private Map<Rank, Integer> rankings;

    public Rankings(Map<Rank, Integer> rankings) {
        this.rankings = Collections.unmodifiableMap(rankings);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("3개 일치 (5000원)- %d개\n", rankings.get(Rank.FIFTH)));
        sb.append(String.format("4개 일치 (50000원)- %d개\n", rankings.get(Rank.FOURTH)));
        sb.append(String.format("5개 일치 (1500000원)- %d개\n", rankings.get(Rank.THIRD)));
        sb.append(String.format("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", rankings.get(Rank.SECOND)));
        sb.append(String.format("6개 일치 (2000000000원)- %d개\n", rankings.get(Rank.FIRST)));

        return sb.toString();
    }
}
