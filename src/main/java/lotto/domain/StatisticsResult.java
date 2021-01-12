package lotto.domain;

import lotto.StatisticsType;
import java.util.HashMap;
import java.util.Objects;

public class StatisticsResult {

    HashMap<StatisticsType, Integer> rankCount = new HashMap<>();
    private int ticketCount = 0;

    public StatisticsResult() {
        for( StatisticsType type : StatisticsType.values() ) {
            rankCount.put(type, 0);
        }
    }

    public void increaseTypeCount(StatisticsType type) {
        rankCount.put(type, rankCount.get(type) + 1);
        this.ticketCount++;
    }

    public double getYield() {
        return this.calculateBenefit() / (this.ticketCount * LottoTicket.LOTTO_PRICE );
    }

    private double calculateBenefit() {
        double benefit = 0;
        for( StatisticsType type : StatisticsType.values() ) {
            benefit += type.getJackpot() * rankCount.get(type);
        }
        return benefit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsResult that = (StatisticsResult) o;
        return rankCount.equals(that.rankCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCount);
    }

    @Override
    public String toString() {
        return "3개 일치 ("+ StatisticsType.THREE.getJackpot() +"원)-" + rankCount.get(StatisticsType.THREE) + "\n" +
                "4개 일치 ("+ StatisticsType.FOUR.getJackpot()  +"원)-" + rankCount.get(StatisticsType.FOUR) + "\n" +
                "5개 일치 ("+ StatisticsType.FIVE.getJackpot()  +"원)-" + rankCount.get(StatisticsType.FIVE) + "\n" +
                "5개 일치, 보너스 볼 일치("+ StatisticsType.FIVE_WITH_BONUS.getJackpot()  +"원)-" + rankCount.get(StatisticsType.FIVE_WITH_BONUS) + "\n" +
                "6개 일치 (" + StatisticsType.SIX.getJackpot()  + "원)-" + rankCount.get(StatisticsType.SIX) + "\n";
    }
}
