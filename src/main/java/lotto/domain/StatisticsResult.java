package lotto.domain;

import lotto.StatisticsType;

import java.util.HashMap;
import java.util.Objects;

public class StatisticsResult {

    private static final int NONE_JACKPOT = 0;
    private static final int THREE_WINNING_JACKPOT = 5000;
    private static final int FOUR_WINNING_JACKPOT = 50000;
    private static final int FIVE_WINNING_JACKPOT = 1500000;
    private static final int FIVE_BONUS_WINNING_JACKPOT = 30000000;
    private static final int SIX_WINNING_JACKPOT = 2000000000;

    HashMap<StatisticsType, Integer> hashMap = new HashMap<>();
    static HashMap<StatisticsType, Integer> priceHash = new HashMap<>();
    private int ticketCount = 0;

    static {
        priceHash.put(StatisticsType.NONE, NONE_JACKPOT);
        priceHash.put(StatisticsType.THREE, THREE_WINNING_JACKPOT);
        priceHash.put(StatisticsType.FOUR, FOUR_WINNING_JACKPOT);
        priceHash.put(StatisticsType.FIVE, FIVE_WINNING_JACKPOT);
        priceHash.put(StatisticsType.FIVE_WITH_BONUS, FIVE_BONUS_WINNING_JACKPOT);
        priceHash.put(StatisticsType.SIX, SIX_WINNING_JACKPOT);
    }


    public StatisticsResult() {
        for( StatisticsType type : StatisticsType.values() ) {
            hashMap.put(type, 0);
        }
    }

    public void increaseTypeCount(StatisticsType type) {
        hashMap.put(type, hashMap.get(type) + 1);
        this.ticketCount++;
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
        return "3개 일치 ("+ THREE_WINNING_JACKPOT +"원)-" + hashMap.get(StatisticsType.THREE) + "\n" +
                "4개 일치 ("+ FOUR_WINNING_JACKPOT +"원)-" + hashMap.get(StatisticsType.FOUR) + "\n" +
                "5개 일치 ("+ FIVE_WINNING_JACKPOT +"원)-" + hashMap.get(StatisticsType.FIVE) + "\n" +
                "5개 일치, 보너스 볼 일치("+ FIVE_BONUS_WINNING_JACKPOT +"원)-" + hashMap.get(StatisticsType.FIVE_WITH_BONUS) + "\n" +
                "6개 일치 (" + SIX_WINNING_JACKPOT + "원)-" + hashMap.get(StatisticsType.SIX) + "\n";
    }

    public double benefit() {
        double sumPrice = 0;
        for( StatisticsType type : StatisticsType.values() ) {
            sumPrice += priceHash.get(type) * hashMap.get(type);
        }
        sumPrice = sumPrice / (this.ticketCount * 1000);
        return sumPrice;
    }

}
