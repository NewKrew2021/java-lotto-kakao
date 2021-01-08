package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public int getNumOfLotto() {
        return lottos.size();
    }

    public Map<Rank, Integer> raffle(Lotto winningNumber, LottoNumber bonusNumber) {
        Map<Rank, Integer> rankingsMap = new TreeMap<>();
        for (Lotto lotto : lottos) {
            int count = winningNumber.matchCount(lotto);
            int bonusCount = lotto.isContain(bonusNumber) ? 1 : 0;
            Rank rank = getRank(count, bonusCount);
            rankingsMap.put(rank, rankingsMap.getOrDefault(rank, 0) + 1);
        }
        return rankingsMap;
    }

    private Rank getRank(int count, int bonusCount) {
        if (count == 6) {
            return Rank.FIRST;
        }
        if (count == 5 && bonusCount == 1) {
            return Rank.SECOND;
        }
        if (count == 5) {
            return Rank.THIRD;
        }
        if (count == 4) {
            return Rank.FOURTH;
        }
        if (count == 3) {
            return Rank.FIFTH;
        }
        return Rank.BOOM;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append("\n");
        }
        return sb.toString();
    }
}
