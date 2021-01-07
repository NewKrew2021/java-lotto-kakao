package lotto;

import java.util.HashMap;
import java.util.Map;

public class RankTable {

    private static final Map<Integer, LottoRank> RANK_TABLE = new HashMap<Integer, LottoRank>() {{
        put(60, LottoRank.FIRST);
        put(51, LottoRank.SECOND);
        put(50, LottoRank.THIRD);
        put(40, LottoRank.FOURTH);
        put(30, LottoRank.FIFTH);
    }};

    public static LottoRank get(int code) {
        return RANK_TABLE.get(code);
    }

}
