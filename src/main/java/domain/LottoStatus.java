package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum LottoStatus {
    FIRST(2_000_000_000L, 6),
    SECOND(30_000_000L, 5),
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3),
    NONE(0, 0);

    private final long winnings;
    private final int matchedLottoNumberCount;

    private static final List<LottoStatus> lottoStatusesExceptNone = new ArrayList<>();

    static {
        for (LottoStatus e : values()) {
            lottoStatusesExceptNone.add(e);
        }
        lottoStatusesExceptNone.remove(LottoStatus.NONE);
        Collections.sort(lottoStatusesExceptNone, Comparator.reverseOrder());
    }

    LottoStatus(long winnings, int matchedLottoNumberCount) {
        this.winnings = winnings;
        this.matchedLottoNumberCount = matchedLottoNumberCount;
    }

    public long getWinnings() {
        return winnings;
    }

    public int getMatchedLottoNumberCount() {
        return matchedLottoNumberCount;
    }

    public static LottoStatus findStatus(int matchedLottoNumberCount, boolean isBonusNumberMatched) {
        if (matchedLottoNumberCount == LottoStatus.SECOND.matchedLottoNumberCount) {
            return secondOrThirdPrize(isBonusNumberMatched);
        }
        return lottoStatusesExceptNone.stream()
                .filter(lotto -> lotto.getMatchedLottoNumberCount() == matchedLottoNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public static LottoStatus secondOrThirdPrize(boolean isBonusNumberMatched) {
        if (isBonusNumberMatched) {
            return LottoStatus.SECOND;
        }
        return LottoStatus.THIRD;
    }

    public static List<LottoStatus> getLottoStatusesExceptNone() {
        return lottoStatusesExceptNone;
    }
}