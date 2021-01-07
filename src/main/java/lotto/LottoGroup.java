package lotto;

import java.util.List;
import java.util.Objects;

public class LottoGroup {
    private final List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public LottoResult getLottoResult(WinningNumberSet winningNumberSet) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoGroup) {
            Rank rank = lotto.compareWithWinning(winningNumberSet);
            lottoResult.addRank(rank);
        }
        return lottoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGroup that = (LottoGroup) o;
        return Objects.equals(lottoGroup, that.lottoGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGroup);
    }
}
