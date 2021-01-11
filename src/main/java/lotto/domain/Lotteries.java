package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public Lotteries() {
        lotteries = new ArrayList<>();
    }

    public LotteryRank calculateRank(LotteryAnswer lotteryAnswer) {
        HashMap<LotteryPrize, Integer> ranks = new HashMap<>();
        for (Lottery lottery : lotteries) {
            LotteryPrize rank = lottery.checkRank(lotteryAnswer);
            ranks.put(rank, ranks.getOrDefault(rank,0) + 1);
        }
        return new LotteryRank(ranks);
    }

    public static List<Lottery> getRandomLotteries(int count) {
        List<Lottery> lotteryList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteryList.add(Lottery.createRandomLottery());
        }
        return lotteryList;
    }

    public void push(Lottery lottery) {
        lotteries.add(lottery);
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
