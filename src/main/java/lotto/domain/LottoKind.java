package lotto.domain;

public class LottoKind {
    private final int selfLottoCount;
    private final int randomLottoCount;

    public LottoKind(int selfLottoCount, int randomLottoCount) {
        this.selfLottoCount = selfLottoCount;
        this.randomLottoCount = randomLottoCount;
    }

    public int getSelfLottoCount() {
        return selfLottoCount;
    }

    public int getRandomLottoCount() {
        return randomLottoCount;
    }
}
