package lotto.domain;

import java.util.Map;
import java.util.TreeMap;

public class Rankings {

    Map<Rank, Integer> rankings;

    public Rankings() {
        rankings = new TreeMap<>();
        for (Rank rank : Rank.values()) {
            rankings.put(rank, 0);
        }
    }

    public Rankings(Map<Rank, Integer> rankings) {
        this.rankings = rankings;
    }

    public void addRank(Rank rank) {
        if (rank.equals(Rank.BOOM)) {
            return;
        }
        rankings.compute(rank, (k, v) -> v + 1);
    }

    public int getRank(Rank rank) {
        return rankings.get(rank);
    }

}
