package LottoMission.domain;

import java.util.*;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        Collections.sort(this.lottos);
    }

    public Map<Rank, Integer> getAllLottoRank(LottoAnswer lottoAnswer) {
        Map<Rank, Integer> result = new TreeMap<>();
        for (Rank lotteryWinnings : Rank.values()) {
            result.put(lotteryWinnings, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = lotto.calculateRank(lottoAnswer);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public int getSumAllWinningMoney(LottoAnswer answer) {
        return lottos.stream()
                .map(e -> e.calculateRank(answer))
                .mapToInt(Rank::getMoney)
                .sum();
    }

    public int getCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
