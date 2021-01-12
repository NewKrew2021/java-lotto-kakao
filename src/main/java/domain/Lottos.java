package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lottos {

    private final List<Lotto> autoLottos;
    private List<Lotto> manualLottos;

    public Lottos(int totalCount) {
        autoLottos = new ArrayList<>();
        for (int count = 0; count < totalCount; count++) {
            autoLottos.add(new Lotto());
        }
    }

    public Lottos(int totalCount, List<Lotto> manualLottos) {
        autoLottos = new ArrayList<>();
        for (int count = 0; count < totalCount; count++) {
            autoLottos.add(new Lotto());
        }
        this.manualLottos = manualLottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.autoLottos = lottos;
    }


    public List<Lotto> getAutoLottos() {
        return autoLottos;
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }

    public HashMap<LottoRank, Integer> getRankCounts(WinningLotto winningLotto) {
        HashMap<LottoRank, Integer> rankCounts = new HashMap<>();

        for (Lotto lotto : autoLottos) {
            LottoRank lottoRank = LottoRank.getLottoRank(lotto, winningLotto);
            int count = rankCounts.containsKey(lottoRank) ? rankCounts.get(lottoRank) : 0;
            rankCounts.put(lottoRank, count + 1);
        }

        for (Lotto lotto : manualLottos) {
            LottoRank lottoRank = LottoRank.getLottoRank(lotto, winningLotto);
            int count = rankCounts.containsKey(lottoRank) ? rankCounts.get(lottoRank) : 0;
            rankCounts.put(lottoRank, count + 1);
        }

        return rankCounts;
    }
}
