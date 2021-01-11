package lotto.domain;

import lotto.exception.FailBuyLottoException;

public class LottoKind {
    public static final int ZERO = 0;
    private final int selfLottoCount;
    private final int randomLottoCount;

    public LottoKind(int selfLottoCount, int randomLottoCount) {
        if(randomLottoCount < ZERO) {
            throw new FailBuyLottoException();
        }
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
