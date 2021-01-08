package lotto.dto;

import java.util.List;

public class LottoResultDTO {

    private List<Integer> rankCount;
    private double profitRate;

    public List<Integer> getRankCount() {
        return rankCount;
    }

    public void setRankCount(List<Integer> rankCount) {
        this.rankCount = rankCount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(int profitRate) {
        this.profitRate = profitRate;
    }
}
