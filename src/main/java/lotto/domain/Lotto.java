package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Digit> digits;

    public Lotto(List<Integer> digits) {
        if (isInvalidNumberOfDigits(digits)) {
            throw new IllegalArgumentException("숫자는 6개만 입력해주세요.");
        }
        if (isDuplicate(digits)) {
            throw new IllegalArgumentException("숫자는 중복되지 않게 입력해주세요.");
        }
        Collections.sort(digits);
        this.digits = mapDigit(digits);
    }

    private boolean isDuplicate(List<Integer> digits) {
        return digits.stream()
                .distinct()
                .count() != digits.size();
    }

    private List<Digit> mapDigit(List<Integer> digits) {
        return digits.stream()
                .map(Digit::new)
                .collect(Collectors.toList());
    }

    private boolean isInvalidNumberOfDigits(List<Integer> digits) {
        return digits.size() != 6;
    }

    public int matchCount(Lotto lotto) {
        return (int) digits.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(Digit digit) {
        return digits.contains(digit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(digits, lotto.digits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digits);
    }

    @Override
    public String toString() {
        StringJoiner strJoiner = new StringJoiner(", ", "[", "]");

        for (Digit digit : digits) {
            strJoiner.add(digit.toString());
        }

        return strJoiner.toString();
    }
}
