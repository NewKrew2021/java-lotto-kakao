package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum LottoStatus {
    NONE(0L, 0, false),
    FIFTH(5000L, 3, false),
    FOURTH(50000L, 4, false),
    THIRD(1500000L, 5, false),
    SECOND(30000000L, 5, true),
    FIRST(2000000000L, 6, false);

    private final long winnings;
    private final int matchingCount;
    private final boolean isBonusNumberMatched;

    private static final List<LottoStatus> lottoStatuses = new ArrayList<>();

    static {
        Collections.addAll(lottoStatuses, values());
        lottoStatuses.sort(Comparator.reverseOrder());
    }

    LottoStatus(long winnings, int matchingCount, boolean isBonusNumberMatched) {
        this.winnings = winnings;
        this.matchingCount = matchingCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }

    public long getWinnings() {
        return winnings;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public static LottoStatus findStatus(int matchingCount, boolean isBonusNumberMatched) {
        if (matchingCount == LottoStatus.SECOND.matchingCount) {
            return secondOrThird(isBonusNumberMatched);
        }
        return lottoStatuses.stream()
                .filter(lotto -> lotto.getMatchingCount() == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    private static LottoStatus secondOrThird(boolean isBonusNumberMatched) {
        if (isBonusNumberMatched) {
            return LottoStatus.SECOND;
        }
        return LottoStatus.THIRD;
    }
}
