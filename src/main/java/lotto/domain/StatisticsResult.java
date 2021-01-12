package lotto.domain;

import lotto.StatisticsType;

import java.util.HashMap;
import java.util.Objects;

public class StatisticsResult {

    HashMap<StatisticsType, Integer> countOfType = new HashMap<>();

    public StatisticsResult() {
        for( StatisticsType type : StatisticsType.values() ) {
            countOfType.put(type, 0);
        }
    }

    public void increaseTypeCount(StatisticsType type) {
        countOfType.put(type, countOfType.get(type) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsResult that = (StatisticsResult) o;
        return countOfType.equals(that.countOfType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfType);
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원)-" + countOfType.get(StatisticsType.THREE) + "\n" +
                "4개 일치 (50,000원)-" + countOfType.get(StatisticsType.FOUR) + "\n" +
                "5개 일치 (1,500,000원)-" + countOfType.get(StatisticsType.FIVE) + "\n" +
                "5개 일치, 보너스 볼 일치(30,000,000원)-" + countOfType.get(StatisticsType.FIVE_WITH_BONUS) + "\n" +
                "6개 일치 (2,000,000,000원)-" + countOfType.get(StatisticsType.SIX) + "\n";
    }

    public String benefit(int ticketCount) {
        int sumPrice = 0;
        for( StatisticsType type : StatisticsType.values() ) {
            sumPrice += type.price * countOfType.get(type);
        }
        sumPrice = sumPrice / (ticketCount * LottoMoney.LOTTO_PRICE);
        return "총 수익률은 " + sumPrice + "입니다";
    }

}
