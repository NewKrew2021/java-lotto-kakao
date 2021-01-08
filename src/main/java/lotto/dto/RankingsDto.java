package lotto.dto;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class RankingsDto {

    private Map<Rank, Integer> rankings;

    public RankingsDto() {
        rankings = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankings.put(rank, 0);
        }
    }

    public RankingsDto(Map<Rank, Integer> rankings) {
        this.rankings = rankings;
    }

    public Map<Rank, Integer> getRankings() {
        return rankings;
    }

    public void addRank(Rank rank) {
        rankings.compute(rank, (k, v) -> v + 1);
    }
}
