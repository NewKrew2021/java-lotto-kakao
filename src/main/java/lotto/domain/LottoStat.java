package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoStat {
    private Map<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);

    public LottoStat() {
        for (Ranking ranking : Ranking.values()) {
            statistics.put(ranking, 0);
        }
    }

    public void addValue(Ranking key, int value) {
        statistics.put(key, statistics.get(key) + value);
    }

    public long getReward() {
        long reward = 0;
        for (Ranking ranking : statistics.keySet()) {
            reward += ranking.getPrize() * statistics.get(ranking);
        }
        return reward;
    }

    public String toString() {
        String result = "";
        for (Ranking ranking : statistics.keySet()) {
            result += makeString(ranking) + "\n";
        }
        return result;
    }

    private String makeString(Ranking ranking) {
        String result = ranking.getMatchCount() + "개 일치";
        if(ranking.isMatchBonus())
            result += ", 보너스 볼 일치";
        result += " (" + ranking.getPrize() + "원) - " + statistics.get(ranking) + "개";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStat lottoStat = (LottoStat) o;
        return Objects.equals(statistics, lottoStat.statistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statistics);
    }
}
