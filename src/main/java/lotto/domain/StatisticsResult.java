package lotto.domain;

import lotto.StatisticsType;

import java.util.HashMap;
import java.util.Objects;

public class StatisticsResult {

    HashMap<StatisticsType, Integer> hashMap = new HashMap<>();
    static HashMap<StatisticsType, Integer> priceHash = new HashMap<>();
    static {
        priceHash.put(StatisticsType.NONE, 0);
        priceHash.put(StatisticsType.THREE, 5000);
        priceHash.put(StatisticsType.FOUR, 50000);
        priceHash.put(StatisticsType.FIVE, 1500000);
        priceHash.put(StatisticsType.FIVE_WITH_BONUS, 30000000);
        priceHash.put(StatisticsType.SIX, 2000000000);
    }


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

    @Override
    public String toString() {
        return "3개 일치 (5,000원)-" + hashMap.get(StatisticsType.THREE) + "\n" +
                "4개 일치 (50,000원)-" + hashMap.get(StatisticsType.FOUR) + "\n" +
                "5개 일치 (1,500,000원)-" + hashMap.get(StatisticsType.FIVE) + "\n" +
                "5개 일치, 보너스 볼 일치(30,000,000원)-" + hashMap.get(StatisticsType.FIVE_WITH_BONUS) + "\n" +
                "6개 일치 (2,000,000,000원)-" + hashMap.get(StatisticsType.SIX) + "\n";
    }

    private String benefit(int ticketCount) {
        int sumPrice = 0;
        for( StatisticsType type : StatisticsType.values() ) {
            sumPrice += priceHash.get(type) * hashMap.get(type);
        }
        sumPrice = sumPrice / ticketCount * 1000;
        return "총 수익률은 " + sumPrice + "입니다";
    }

}
