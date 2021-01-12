package mission.lotto.util;

import mission.lotto.domain.*;

import java.util.Map;
import java.util.TreeMap;

public class Statistics {

    public static Map<Rank, Integer> getAllLottoRank(Lottos lottos, LottoAnswer lottoAnswer) {
        Map<Rank, Integer> result = new TreeMap<>();
        for (Rank lotteryWinnings : Rank.values()) {
            result.put(lotteryWinnings, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = lotto.calculateRank(lottoAnswer);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public static int getSumAllWinningMoney(Lottos lottos, LottoAnswer answer) {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.calculateRank(answer))
                .mapToInt(Rank::getMoney)
                .sum();
    }

    public static float getRateOfProfit(Lottos lottos, LottoAnswer lottoAnswer, UserMoney userMoney) {
        return (float) Statistics.getSumAllWinningMoney(lottos, lottoAnswer) / userMoney.getUserMoney();
    }

}
