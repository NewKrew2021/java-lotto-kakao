package mission.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto implements Comparable<Lotto> {

    public static final Integer LOTTO_PRICE = 1000;
    public static final int MAX_NUMBERS_LENGTH = 6;
    private final Set<Number> numbers;

    public Lotto(List<Integer> numbers) {
        Set<Number> lottoNums = numbers.stream()
                .map(Number::new)
                .collect(Collectors.toSet());

        if (checkNumbersLength(lottoNums)) {
            throw new IllegalArgumentException("로또는 중복 없는 6자리만 가능합니다.");
        }

        this.numbers = lottoNums;
    }

    public Rank calculateRank(LottoAnswer answer) {
        Set<Number> answerNumbers = answer.getAnswerNumbers();
        Set<Number> combine = new HashSet<>(answerNumbers);
        combine.addAll(numbers);

        int correctNo = 12 - combine.size();
        Number bonus = answer.getBonusNumber();

        boolean hasBonusNo = isContainLottoNumber(bonus);
        return Rank.getRank(correctNo, hasBonusNo);
    }

    private boolean checkNumbersLength(Set<Number> temp) {
        return temp.size() != MAX_NUMBERS_LENGTH;
    }

    public boolean isContainLottoNumber(Number lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public int compareTo(Lotto lotto) {
        return Integer.compare(Objects.hash(this), Objects.hash(lotto));
    }

    public Set<Number> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
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
}
