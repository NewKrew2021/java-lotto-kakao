package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    NOTHING(0, "2개 이하 일치"),
    FIFTH(5_000, "3개 일치"),
    FOURTH(50_000, "4개 일치"),
    THIRD(1_500_000, "5개 일치"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000, "6개 일치");

    private static final MatchResult MATCH_SIX_BALL = new MatchResult(6, false);
    private static final MatchResult MATCH_FIVE_BALL_BONUS = new MatchResult(5, true);
    private static final MatchResult MATCH_FIVE_BALL = new MatchResult(5, false);
    private static final MatchResult MATCH_FOUR_BALL = new MatchResult(4, false);
    private static final MatchResult MATCH_THREE_BALL = new MatchResult(3, false);
    private static final MatchResult MATCH_TWO_BALL = new MatchResult(2, false);
    private static final MatchResult MATCH_ONE_BALL = new MatchResult(1, false);
    private static final MatchResult MATCH_NOTHING = new MatchResult(0, false);
    private static final Map<MatchResult, LottoRank> RANK_TABLE = new HashMap<MatchResult, LottoRank>() {{
        put(MATCH_SIX_BALL, LottoRank.FIRST);
        put(MATCH_FIVE_BALL_BONUS, LottoRank.SECOND);
        put(MATCH_FIVE_BALL, LottoRank.THIRD);
        put(MATCH_FOUR_BALL, LottoRank.FOURTH);
        put(MATCH_THREE_BALL, LottoRank.FIFTH);
        put(MATCH_TWO_BALL, LottoRank.NOTHING);
        put(MATCH_ONE_BALL, LottoRank.NOTHING);
        put(MATCH_NOTHING, LottoRank.NOTHING);
    }};

    private final long price;
    private final String message;

    LottoRank(long price, String message) {
        this.price = price;
        this.message = message;
    }

    public static LottoRank get(MatchResult result) {
        return RANK_TABLE.get(result);
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return message + " (" + price + "원)";
    }
}
