package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningInfo {

    private final List<Long> PRIZE = Arrays.asList(5000l, 50000l, 1500000l, 30000000l, 2000000000l);

    private final List<Integer> winningInfo;

    public WinningInfo(List<Integer> winningInfo) {
        this.winningInfo = winningInfo;
    }

    public List<Integer> getWinningInfo() {
        return winningInfo;
    }

    public long getSum() {
        long sum = 0;
        for (int i = 0; i < winningInfo.size(); i++) {
            sum += winningInfo.get(i) * PRIZE.get(i);
        }

        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfo that = (WinningInfo) o;
        return Objects.equals(winningInfo, that.winningInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningInfo);
    }
}
