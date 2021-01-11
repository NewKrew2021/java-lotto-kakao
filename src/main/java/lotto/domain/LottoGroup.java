package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGroup {
    private final List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public LottoResult getLottoResult(WinningNumberSet winningNumberSet) {
        LottoResult lottoResult = new LottoResult();
        lottoGroup.stream()
                .map(lotto -> lotto.compareWithWinning(winningNumberSet))
                .forEach(lottoResult::addRank);

        return lottoResult;
    }

    public static LottoGroup createRandomLottoGroup(PurchaseMoney purchaseMoney) {
        return new LottoGroup(IntStream.range(0, purchaseMoney.getLottoAmount())
                .mapToObj(value -> new Lotto())
                .collect(Collectors.toList()));
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
