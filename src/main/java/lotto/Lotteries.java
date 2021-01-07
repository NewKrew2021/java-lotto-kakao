package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Lotteries {
    private List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteryList) {
        lotteries = lotteryList;
    }

    public Lotteries() {
        lotteries = new ArrayList<Lottery>();
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

    public HashMap<Integer, Integer> getRanks(List<LotteryNumber> answerNumbers, LotteryNumber bonusNumber) {
        HashMap<Integer, Integer> ranks = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            ranks.put(i, 0);
        }
        ranks.put(Lottery.NONE, 0);

        for (Lottery lottery : lotteries) {
            int rank = lottery.checkRank(answerNumbers, bonusNumber);
            ranks.put(rank, ranks.get(rank) + 1);
        }
        return ranks;
    }
}
