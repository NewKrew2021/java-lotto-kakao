package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class Rankings {

    private Map<Rank, Integer> rankings;

    public Rankings(Map<Rank, Integer> rankings) {
        for (Rank rank : Rank.values()) {
            rankings.putIfAbsent(rank, 0);
        }
        this.rankings = Collections.unmodifiableMap(rankings);
    }

    public int getCountOfRank(Rank rank) {
        return rankings.get(rank);
    }
}
