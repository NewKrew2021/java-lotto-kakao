package lottoMission.domain;

import java.util.*;

public class Lotto implements Comparable<Lotto> {

    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public LotteryWinnings winningPrize(LottoAnswer answer) {
        return LotteryWinnings.getState(
                answer.getMatchNumberCount(this.numbers)
                , answer.isMatchBonusNumber(this.numbers));
    }

    public List<Integer> getLottoNumberList() {
        return numbers.getNumbersList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public int compareTo(Lotto lotto) {
        return Integer.compare(Objects.hash(this), Objects.hash(lotto));
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
