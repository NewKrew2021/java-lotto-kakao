package domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(2,  0, "0~2개 일치 (0원)- "),
    FIFTH(3,  5000, "3개 일치 (5000원)- "),
    FOURTH(4, 50000, "4개 일치 (50000원)- "),
    THIRD(5, 1500000, "5개 일치 (1500000원)- "),
    SECOND(5,  30000000, "5개 일치, 보너스 볼 일치(30000000원)- "),
    FIRST(6,  2000000000, "6개 일치 (2000000000원)- ");

    private final int rightCounts;
    private final int reward;
    private final String resultPrefix;

    LottoRank(int rightCounts, int reward, String resultPrefix) {
        this.rightCounts = rightCounts;
        this.reward = reward;
        this.resultPrefix = resultPrefix;
    }

    public static LottoRank getLottoRank(Lotto lotto, WinningLotto winningLotto) {
        return getLottoRank(winningLotto.calculateSameBall(lotto), winningLotto.hasSameBonusBall(lotto));
    }

    public static LottoRank getLottoRank(int count, boolean matchBonusBall) {
        if(sameCount(count,SECOND) && matchBonusBall){
            return LottoRank.SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> sameCount(count, lottoRank))
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    private static boolean sameCount(int sameCount, LottoRank lottoRank) {
        return lottoRank.rightCounts == sameCount;
    }


    public int getReward() {
        return reward;
    }

    public String getResultPrefix() {
        return resultPrefix;
    }
}
