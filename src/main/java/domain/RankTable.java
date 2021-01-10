package domain;

import java.util.HashMap;
import java.util.Map;

public class RankTable {
    private static final int COUNT_WEIGHT = 10;
    private static final int SECOND_COUNT = 5;

    private static final Map<Integer, LottoRank> RANK_TABLE = new HashMap<Integer, LottoRank>() {{
        put(60, LottoRank.FIRST);
        put(51, LottoRank.SECOND);
        put(50, LottoRank.THIRD);
        put(40, LottoRank.FOURTH);
        put(30, LottoRank.FIFTH);
    }};

    public static LottoRank get(int matchCount, boolean bonus) {
        return RANK_TABLE.get(matchCount * COUNT_WEIGHT
                + (bonus && matchCount == SECOND_COUNT ? 1 : 0));
    }

}
