package lotto;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class WinnerNumber extends LottoTicket {
    private Number bonusNumber;
    private static final Map<Integer, LottoRank> RANK_TABLE = new HashMap<Integer, LottoRank>() {{
        put(60, LottoRank.FIRST);
        put(51, LottoRank.SECOND);
        put(50, LottoRank.THIRD);
        put(40, LottoRank.FOURTH);
        put(30, LottoRank.FIFTH);
    }};

    public WinnerNumber(Set<Number> numbers, Number bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getRank(LottoTicket lottoTicket) {
        int count = matchCount(lottoTicket);
        boolean bonus = lottoTicket.contains(bonusNumber);
        return RANK_TABLE.get(count * 10 + (bonus && count == 5 ? 1 : 0));
    }

    @Override
    public String toString() {
        return super.toString() + " bonusNumber : " + bonusNumber;
    }
}
