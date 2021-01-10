package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RankTable {

    private static final Map<Integer, LottoRank> RANK_TABLE = new HashMap<Integer, LottoRank>() {{
        put(60, LottoRank.FIRST);
        put(51, LottoRank.SECOND);
        put(50, LottoRank.THIRD);
        put(40, LottoRank.FOURTH);
        put(30, LottoRank.FIFTH);
    }};

    public static LottoRank get(int matchCount, boolean bonusNumber) {
        return RANK_TABLE.get(matchCount * 10 + (bonusNumber && matchCount == 5 ? 1 : 0));
    }

}
