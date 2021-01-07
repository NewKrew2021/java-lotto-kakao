package LottoMission.domain;

import java.util.*;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        Collections.sort(this.lottos);
    }

    public Map<LotteryWinnings,Integer> getAllLottoRankCount(LottoAnswer lottoAnswer){
        Map<LotteryWinnings, Integer> result = new TreeMap<>();
        for (LotteryWinnings lotteryWinnings : LotteryWinnings.values()) {
            result.put(lotteryWinnings, 0);
        }
        for (Lotto lotto : lottos) {
            lotto.winningPrize(lottoAnswer);
            LotteryWinnings winningsStat = lotto.getWinningsStat();
            result.put(winningsStat, result.get(winningsStat) + 1);
        }
        return result;
    }

    public int getSumAllWinningMoney(LottoAnswer answer){
        return lottos
                .stream()
                .mapToInt(lotto -> lotto.getWinningMoney(answer))
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
