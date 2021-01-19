package lotto.domain;

import java.util.*;

public class LottoResult {
    private final Map<Rank, Integer> ranks = new HashMap<>();

    public LottoResult() {
        Arrays.stream(Rank.values()).forEach(rank -> ranks.put(rank, 0));
    }

    public void putRank(Rank rank) {
        ranks.put(rank, ranks.get(rank) + 1);
    }

    public int getCountOf(Rank rank) {
        return ranks.get(rank);
    }

    public double getRate() {
        long userMoney = Ticket.TICKET_PRICE * getCountOfAllRecoredRank();
        return (double)getSumOfPrizes() / userMoney;
    }

    private long getCountOfAllRecoredRank() {
        int countSum = 0;
        for(Rank rank : Rank.values()){
            countSum += getCountOf(rank);
        }
        return countSum;
    }

    private long getSumOfPrizes() {
        long sum = 0;
        for (Rank rank : Rank.values()) {
            sum += getCountOf(rank) * rank.getPrize();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoResult)) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
