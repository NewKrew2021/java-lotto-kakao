package LottoMission.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto implements Comparable<Lotto> {

    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public Rank calculateRank(LottoAnswer answer) {
        Set<Number> answerNumbers = answer.getAnswerNumbers();
        Set<Number> combine = new HashSet<>(answerNumbers);
        combine.addAll(this.numbers.getNumbers());

        int correctNo = 12 - combine.size();
        Number bonus = answer.getBonusNumber();

        boolean hasBonusNo = numbers.isContainLottoNumber(bonus);
        return Rank.getRank(correctNo, hasBonusNo);
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
