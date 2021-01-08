package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
        for (Lotto lotto : lottos) {
            Rank rank = winningNumber.matchLottoRank(lotto, bonusNumber);
            rankingsMap.put(rank, rankingsMap.getOrDefault(rank, 0) + 1);
        }
        return new Statistics(rankingsMap);
    }

    public LottosDto getLottosData() {
        return new LottosDto(lottos.stream()
                .map(Lotto::getLottoData)
                .collect(Collectors.toList()));
    }
}
