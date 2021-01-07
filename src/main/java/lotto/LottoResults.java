package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> results;

    public LottoResults() {
        results = new HashMap<LottoRank, Integer>() {{
            for (LottoRank rank : LottoRank.values()) {
                put(rank, 0);
            }
        }};
    }

    public void upsert(LottoRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return results.get(rank);
    }

    public String result(int price) {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += results.get(rank) * rank.getPrice();
        }
        return this + "총 수익률은 " + (long) (sum / price * 100) + "%입니다.";
    }

    @Override
    public String toString() {
        String s = "";
        for (LottoRank rank : LottoRank.values()) {
            s += rank + " - " + results.get(rank) + "개\n";
        }
        return s;
    }
}
