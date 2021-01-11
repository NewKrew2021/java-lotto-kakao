package domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningInfo {
    private static final long DEFAULT_COUNT = 0;
    private final Map<Rank, Long> winningInfo;
    private final long totalPrize;

    public WinningInfo(LottoTickets lottoTickets, LottoWinningNumber lottoWinningNumber) {
        Map<Rank, Long> countMap = toMap(lottoTickets.getLottos(), lottoWinningNumber);
        fillDefaultCount(countMap);

        this.winningInfo = countMap;
        this.totalPrize = calculatePrize();
    }

    private long calculatePrize() {
        long sum = 0;
        for (Rank rank : winningInfo.keySet()) {
            sum += rank.getPrize() * winningInfo.get(rank);
        }
        return sum;
    }

    private void fillDefaultCount(Map<Rank, Long> countMap) {
        for (Rank value : Rank.values()) {
            countMap.putIfAbsent(value, DEFAULT_COUNT);
        }
    }

    private Map<Rank, Long> toMap(List<Lotto> lottos, LottoWinningNumber winning) {
        return lottos.stream()
                .map(lotto -> findRank(lotto, winning))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Rank findRank(Lotto lotto, LottoWinningNumber winning) {
        return Rank.getRank(winning.getMatchedCount(lotto), winning.isContainsBounusNumber(lotto));
    }

    public Map<Rank, Long> getWinningInfo() {
        return winningInfo;
    }

    public long getTotalPrize() {
        return totalPrize;
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
