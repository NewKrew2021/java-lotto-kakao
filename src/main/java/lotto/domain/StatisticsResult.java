package lotto.domain;

import lotto.StatisticsType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

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
        String result = "";
        for (StatisticsType type: StatisticsType.valuesExceptNone()) {
            result += (type.howmany + "개 일치"
                    + (type.isBonus ? "보너스 볼 일치" : "")
                    + "(" + type.price + "원)-"
                    + countOfType.get(type) + "\n");
        }
        return result;
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
