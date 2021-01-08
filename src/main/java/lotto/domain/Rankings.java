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

    public int getRank(Rank rank) {
        return rankings.get(rank);
    }

}
