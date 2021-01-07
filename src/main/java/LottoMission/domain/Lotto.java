package LottoMission.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto implements Comparable<Lotto> {

    private final LottoNumbers numbers;
    private LotteryWinnings winnings;

    public Lotto(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public void winningPrize(LottoAnswer answer) {
        Set<LottoNumber> answerNumbers = answer.getAnswerNumbers();
        Set<LottoNumber> combine = new HashSet<>(answerNumbers);
        combine.addAll(this.numbers.getNumbers());

        int correctNo = 12 - combine.size();
        LottoNumber bonus = answer.getBonusNumber();

        boolean hasBonusNo = numbers.isContainLottoNumber(bonus);
        winnings = LotteryWinnings.getState(correctNo, hasBonusNo);
    }

    public LotteryWinnings getWinningsStat() {
        return this.winnings;
    }

    public int getWinningMoney(LottoAnswer answer) {
        if (isNullWinnings()) {
            winningPrize(answer);
        }
        return this.winnings.getMoney();
    }

    private boolean isNullWinnings() {
        return this.winnings == null;
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
