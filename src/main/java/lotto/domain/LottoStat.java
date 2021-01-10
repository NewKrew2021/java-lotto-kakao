package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoStat {
    private Map<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);

    public LottoStat(){
        for (Ranking ranking : Ranking.values()) {
            statistics.put(ranking, 0);
        }
    }

    public void addValue(Ranking key, int value){
        statistics.put(key, statistics.get(key) + value);
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
