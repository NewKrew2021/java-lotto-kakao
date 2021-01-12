package domain;

import java.util.*;
import java.util.stream.Collectors;

public enum LottoStatus {
    FIRST(2_000_000_000L, 6),
    SECOND(30_000_000L, 5),
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3),
    NONE(0, 0);

    private static final Comparator<LottoStatus> compareByMatchNumberAndWinnings = Comparator
            .comparing(LottoStatus::getMatchedLottoNumberCount)
            .thenComparing(LottoStatus::getWinnings);

    private final long winnings;
    private final int matchedLottoNumberCount;

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
        return Arrays.stream(LottoStatus.values())
                .filter(lotto -> (lotto.getMatchedLottoNumberCount() == matchedLottoNumberCount && lotto != LottoStatus.NONE))
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
        return Arrays.stream(LottoStatus.values())
                .sorted(compareByMatchNumberAndWinnings)
                .filter(lottoStatus -> lottoStatus != LottoStatus.NONE)
                .collect(Collectors.toList());
    }
}