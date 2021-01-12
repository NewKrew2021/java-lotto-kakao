package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int totalCount) {
        lottos = new ArrayList<>();
        for (int count = 0; count < totalCount; count++) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public List<Lotto> getLottos() {
        return lottos;
    }


    public HashMap<LottoRank, Integer> getRankCounts(WinningLotto winningLotto) {
        HashMap<LottoRank, Integer> rankCounts = new HashMap<>();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = LottoRank.getLottoRank(lotto, winningLotto);
            int count = rankCounts.containsKey(lottoRank) ? rankCounts.get(lottoRank) : 0;
            rankCounts.put(lottoRank, count + 1);
        }

        return rankCounts;
    }
}
