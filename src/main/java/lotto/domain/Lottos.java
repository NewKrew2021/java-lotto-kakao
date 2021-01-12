package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

//    public Rankings raffle(WinningLotto winningNumber) {
//        Map<Rank, Integer> rankingsMap = new TreeMap<>();
//        for (Lotto lotto : lottos) {
//            Rank rank = winningNumber.getRankOfLotto(lotto);
//            rankingsMap.put(rank, rankingsMap.getOrDefault(rank, 0) + 1);
//        }
//        return new Rankings(rankingsMap);
//    }

    public Rankings raffle(WinningLotto winningNumber) {
        return new Rankings(lottos, winningNumber);
    }

    public List<Set<LottoNumber>> getLottosData() {
        return lottos.stream()
                .map(Lotto::getLottoData)
                .collect(Collectors.toList());
    }
}
