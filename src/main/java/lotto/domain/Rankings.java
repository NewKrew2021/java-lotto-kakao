package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rankings {
    public static final int ZERO = 0;

    private final Map<Rank, Integer> rankings;

    public Rankings(Map<Rank, Integer> rankings) {
        this.rankings = Collections.unmodifiableMap(rankings);
    }

    public Rankings(List<Lotto> lottos, WinningLotto winningNumber) {
        Map<Rank, Integer> rankingsMap = new TreeMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = winningNumber.getRankOfLotto(lotto);
            rankingsMap.put(rank, rankingsMap.getOrDefault(rank, ZERO) + 1);
        }
        rankings = rankingsMap;
    }

    public int getCountOfRank(Rank rank) {
        return rankings.getOrDefault(rank, ZERO);
    }
}
