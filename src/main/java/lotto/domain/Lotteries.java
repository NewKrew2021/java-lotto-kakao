package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.HashMap;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteryList) {
        lotteries = lotteryList;
    }

    public Lotteries() {
        lotteries = new ArrayList<>();
    }

    public LotteryRankCounter getLotteryRankCounter(LotteryAnswer lotteryAnswer) {
        return new LotteryRankCounter((HashMap<LotteryRank, Long>) lotteries.stream()
                .collect(Collectors.groupingBy(
                        lottery -> lottery.calculateRank(lotteryAnswer),
                        Collectors.counting()
                        )
                )
        );
    }

    public static List<Lottery> getRandomLotteryList(int count) {
        List<Lottery> lotteryList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteryList.add(Lottery.createRandomLottery());
        }
        return lotteryList;
    }

    @Override
    public String toString() {
        return lotteries.stream().map(Lottery::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries1 = (Lotteries) o;
        return Objects.equals(lotteries, lotteries1.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }
}
