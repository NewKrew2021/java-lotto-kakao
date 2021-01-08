package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankTable {

    private static final MatchResult FIRST = new MatchResult(6, false);
    private static final MatchResult SECOND = new MatchResult(5, true);
    private static final MatchResult THIRD = new MatchResult(5, false);
    private static final MatchResult FOURTH = new MatchResult(4, false);
    private static final MatchResult FIFTH = new MatchResult(3, false);
    private static final Map<MatchResult, LottoRank> RANK_TABLE = new HashMap<MatchResult, LottoRank>() {{
        put(FIRST, LottoRank.FIRST);
        put(SECOND, LottoRank.SECOND);
        put(THIRD, LottoRank.THIRD);
        put(FOURTH, LottoRank.FOURTH);
        put(FIFTH, LottoRank.FIFTH);
    }};

    public static LottoRank get(MatchResult result) {
        return RANK_TABLE.get(result);
    }

}
