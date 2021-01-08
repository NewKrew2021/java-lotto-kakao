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

    public int getSizeOfLotto() {
        return lottos.size();
    }

    public Statistics raffle(Lotto winningNumber, LottoNumber bonusNumber) {
        Map<Rank, Integer> rankingsMap = new TreeMap<>();
        int count;
        boolean bonusCount;
        for (Lotto lotto : lottos) {
            count = winningNumber.matchCount(lotto);
            bonusCount = lotto.isContain(bonusNumber);
            Rank rank = Rank.checkRank(count, bonusCount);
            rankingsMap.put(rank, rankingsMap.getOrDefault(rank, 0) + 1);
        }
        return new Statistics(rankingsMap);
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
