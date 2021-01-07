package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    private final LottoNumbers numbers;
    private int ranking;

    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public int calculateRanking(WinnerNumbers winner) {
        int count = numbers.countIntersection(winner.getWinnerNumber());
        boolean matchBonus = numbers.contains(winner.getBonusBall());
        this.ranking = Ranking(count, matchBonus);
        return this.ranking;
    }

    private int Ranking(int count, boolean matchBonus) {
        if (count == 6)
            return 1;
        if (count == 5 && matchBonus)
            return 2;
        if (count == 5 && !matchBonus)
            return 3;
        if (count == 4)
            return 4;
        if (count == 3)
            return 5;
        return 6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }


}
