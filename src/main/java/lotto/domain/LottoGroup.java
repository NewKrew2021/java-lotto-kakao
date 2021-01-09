package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static LottoGroup createRandomLottoGroup(int count) {
        List<Lotto> lottos = new ArrayList<>();
        RandomGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();

        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.createLottoRandomly(randomGenerateStrategy));
        }

        return new LottoGroup(lottos);
    }

    public int getLottoCount() {
        return lottoGroup.size();
    }

    @Override
    public String toString() {
        return lottoGroup.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
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
