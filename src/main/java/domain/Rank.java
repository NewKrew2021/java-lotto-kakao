package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false, "6개 일치 (200000000원) - "),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치(30000000원) - "),
    THIRD(5, 1_500_000, false, "5개 일치 (150000) - "),
    FOURTH(4, 50_000, false,"4개 일치 (50000원) - "),
    FIFTH(3, 5_000, false, "3개 일치 (5000원) - "),
    NONE(0,0,false,"");

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;
    private final String resultMsg;

    Rank(int matchCount, int prize, boolean matchBonus, String resultMsg) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
        this.resultMsg = resultMsg;
    }

    public static Rank getRank(int matchCount, boolean matchBonus) {
        if(matchCount == SECOND.getMatchCount()){
            return matchBonus ? Rank.SECOND : Rank.THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }


    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}
