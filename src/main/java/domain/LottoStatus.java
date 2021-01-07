package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum LottoStatus {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3);

    private final int winnings;
    private final int matchedLottoNumberCount;

    private static final List<LottoStatus> lottoStatuses = new ArrayList<>();

    static {
        for (LottoStatus e : values()) {
            lottoStatuses.add(e);
        }
        Collections.sort(lottoStatuses, Comparator.reverseOrder());
    }

    LottoStatus(int winnings, int matchedLottoNumberCount) {
        this.winnings = winnings;
        this.matchedLottoNumberCount = matchedLottoNumberCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getMatchedLottoNumberCount() {
        return matchedLottoNumberCount;
    }

    public static LottoStatus findStatus(int matchedLottoNumberCount, boolean isBonusNumberMatched) {
        if (matchedLottoNumberCount == LottoStatus.SECOND.matchedLottoNumberCount) {
            return secondOrThirdPrize(isBonusNumberMatched);
        }
        return lottoStatuses.stream().
                filter(lotto -> lotto.getMatchedLottoNumberCount() == matchedLottoNumberCount).
                findFirst().orElse(null);
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