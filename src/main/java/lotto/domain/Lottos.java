package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<LottoRank> lottosResult(WonLotto wonLotto) {
        List<LottoRank> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = wonLotto.getWonLotto().checkSameCount(lotto);
            boolean isBonus = lotto.contain(wonLotto.getBonusNumber());
            results.add(LottoRank.checkRanking(matchCount, isBonus));
        }
        return results;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Lotto lotto : lottos) {
            str.append(lotto.toString());
        }
        return str.toString();
    }
}
