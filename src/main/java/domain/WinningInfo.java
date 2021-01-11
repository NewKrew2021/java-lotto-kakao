package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WinningInfo {

    private final Map<LottoRank, Integer> info;

    public WinningInfo(Map<LottoRank, Integer> info) {
        this.info = info;
    }

    public long getSumPrize() {
        long sum = 0;
        for (LottoRank lottoRank : info.keySet()) {
            sum += lottoRank.getPrize(info.get(lottoRank));
        }

        return sum;
    }

    public Map<LottoRank, Integer> getInfo() {
        return info;
    }

    public double getYield(Amount amount) {
        return (double) getSumPrize() / amount.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfo that = (WinningInfo) o;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}
