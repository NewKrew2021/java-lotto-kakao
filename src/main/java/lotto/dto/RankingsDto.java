package lotto.dto;

import lotto.domain.Rankings;
import lotto.util.Rank;

import java.util.HashMap;
import java.util.Map;

public class RankingsDto {
    private Map<Rank, Integer> rankings;

    public RankingsDto(Map<Rank, Integer> rankings) {
        this.rankings = new HashMap<>(rankings);
    }

    public static RankingsDto from(Rankings rankingsObj) {
        return new RankingsDto(rankingsObj.getRankings());
    }

    public Map<Rank, Integer> getRankings() {
        return rankings;
    }
}
