package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class Rankings {

    private Map<Rank, Integer> rankings;

    public Rankings(Map<Rank, Integer> rankings) {
        this.rankings = Collections.unmodifiableMap(rankings);
    }

    public int getCountOfRank(Rank rank) {
        return rankings.getOrDefault(rank, 0);
    }
}
