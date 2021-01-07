package lotto.domain;

import lotto.StatisticsType;

import java.util.HashMap;
import java.util.Objects;

public class StatisticsResult {

    HashMap<StatisticsType, Integer> hashMap = new HashMap<>();

    public StatisticsResult() {
        for( StatisticsType type : StatisticsType.values() ) {
            hashMap.put(type, 0);
        }
    }

    public void increaseTypeCount(StatisticsType type) {
        hashMap.put(type, hashMap.get(type) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsResult that = (StatisticsResult) o;
        return hashMap.equals(that.hashMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashMap);
    }
}
