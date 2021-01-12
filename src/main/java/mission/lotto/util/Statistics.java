package mission.lotto.util;

import mission.lotto.domain.*;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Statistics {

    private final Map<Rank, Integer> lottoRanks;

    public Statistics(Lottos lottos, LottoAnswer lottoAnswer) {
        Map<Rank, Integer> lottoRanks = new TreeMap<>();
        for (Rank lotteryWinnings : Rank.values()) {
            lottoRanks.put(lotteryWinnings, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = lotto.calculateRank(lottoAnswer);
            lottoRanks.put(rank, lottoRanks.get(rank) + 1);
        }
        this.lottoRanks = lottoRanks;
    }

    public float getRateOfProfit(UserMoney userMoney) {
        return (float) getSumAllWinningMoney() / userMoney.getUserMoney();
    }

    public Map<Rank, Integer> getLottoRanks() {
        return Collections.unmodifiableMap(this.lottoRanks);
    }

    public int getSumAllWinningMoney() {
        return lottoRanks.keySet().stream()
                .mapToInt(rank -> lottoRanks.get(rank) * rank.getMoney())
                .sum();
    }

}
