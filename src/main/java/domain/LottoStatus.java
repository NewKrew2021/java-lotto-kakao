package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum LottoStatus {
    FIRST(2000000000L, 6),
    SECOND(30000000L, 5),
    THIRD(1500000L, 5),
    FOURTH(50000L, 4),
    FIFTH(5000L, 3);

    private final long winnings;
    private final int matchedLottoNumberCount;

    private static final List<LottoStatus> lottoStatuses = new ArrayList<>();

    static {
        for (LottoStatus e : values()) {
            lottoStatuses.add(e);
        }
        Collections.sort(lottoStatuses, Comparator.reverseOrder());
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
        return lottoStatuses.stream()
                .filter(lotto -> lotto.getMatchedLottoNumberCount() == matchedLottoNumberCount)
                .findFirst()
                .orElse(null);
    }

    public static LottoStatus secondOrThirdPrize(boolean isBonusNumberMatched) {
        if (isBonusNumberMatched) {
            return LottoStatus.SECOND;
        }
        return LottoStatus.THIRD;
    }

    public static List<LottoStatus> getLottoStatuses() {
        return lottoStatuses;
    }
}