package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum LottoStatus {
    NONE(0, 0),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private final int winngs;
    private final int matchedLottoNumberCount;

    private static final List<LottoStatus> lottoStatuses = new ArrayList<>();

    static {
        Collections.addAll(lottoStatuses, values());
        lottoStatuses.sort(Comparator.reverseOrder());
    }

    LottoStatus(int winngs, int matchedLottoNumberCount) {
        this.winngs = winngs;
        this.matchedLottoNumberCount = matchedLottoNumberCount;
    }

    public int getWinngs() {
        return winngs;
    }

    public int getMatchedLottoNumberCount() {
        return matchedLottoNumberCount;
    }

    public static LottoStatus findStatus(int matchedLottoNumberCount, boolean isBonusNumberMatched) {
        if (matchedLottoNumberCount == LottoStatus.SECOND.matchedLottoNumberCount) {
            return secondOrThird(isBonusNumberMatched);
        }
        return lottoStatuses.stream().filter(lotto ->
                lotto.getMatchedLottoNumberCount() == matchedLottoNumberCount).findFirst()
                .orElse(NONE);
    }

    private static LottoStatus secondOrThird(boolean isBonusNumberMatched) {
        if (isBonusNumberMatched) {
            return LottoStatus.SECOND;
        }
        return LottoStatus.THIRD;
    }
}
