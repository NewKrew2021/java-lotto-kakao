package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGroup {
    private final List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public static LottoGroup createManualLottoGroup(List<String> lottoTexts) {
        return new LottoGroup(lottoTexts.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public static LottoGroup createRandomLottoGroup(int count) {
        return new LottoGroup(IntStream.range(0, count)
                .mapToObj(value -> new Lotto())
                .collect(Collectors.toList()));
    }

    public static LottoGroup createLottoGroup(PurchaseMoney purchaseMoney, List<String> lottoTexts) {
        LottoGroup manualLottoGroup = createManualLottoGroup(lottoTexts);
        LottoGroup randomLottoGroup = createRandomLottoGroup(purchaseMoney.getLottoQuantity() - manualLottoGroup.getLottoCount());

        return new LottoGroup(Stream.concat(manualLottoGroup.lottoGroup.stream(), randomLottoGroup.lottoGroup.stream())
                .collect(Collectors.toList()));
    }

    public int getLottoCount() {
        return lottoGroup.size();
    }

    public LottoResult getLottoResult(WinningNumberSet winningNumberSet) {
        LottoResult lottoResult = new LottoResult();
        lottoGroup.stream()
                .map(lotto -> lotto.compareWithWinning(winningNumberSet))
                .forEach(lottoResult::addRank);

        return lottoResult;
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
