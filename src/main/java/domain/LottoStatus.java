package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum LottoStatus {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false);

    private final int winnings;
    private final int matchedLottoNumberCount;
    private final boolean isBonusNumberMatched;

    private static final List<LottoStatus> lottoStatuses = new ArrayList<>();

    static {
        for (LottoStatus e : values()) {
            lottoStatuses.add(e);
        }
        Collections.sort(lottoStatuses, Comparator.reverseOrder());
    }

    LottoStatus(int winnings, int matchedLottoNumberCount, boolean isBonusNumberMatched) {
        this.winnings = winnings;
        this.matchedLottoNumberCount = matchedLottoNumberCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getMatchedLottoNumberCount() {
        return matchedLottoNumberCount;
    }

    public boolean isBonusNumberMatched() {
        return isBonusNumberMatched;
    }

    public static LottoStatus findStatus(int matchedLottoNumberCount, boolean isBonusNumberMatched) {
        if (matchedLottoNumberCount == LottoStatus.SECOND.matchedLottoNumberCount) {
            return lottoStatuses.stream().filter(lotto ->
                    lotto.getMatchedLottoNumberCount() == matchedLottoNumberCount
                            && lotto.isBonusNumberMatched() == isBonusNumberMatched).
                    findFirst().orElse(null);
        }
        return lottoStatuses.stream().filter(lotto ->
                lotto.getMatchedLottoNumberCount() == matchedLottoNumberCount).findFirst().
                orElse(null);
    }

    public static List<LottoStatus> getLottoStatuses() {
        return lottoStatuses;
    }

}