package lotto.domain;


public class Number implements Comparable<Number> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public Number(int number) {
        checkValidNumber(number);
        this.number = number;
    }

    private void checkValidNumber(int number) {
        if (MIN_LOTTO_NUMBER > number || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("숫자가 잘못되었습니다 : " + number);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public int compareTo(Number o) {
        return this.number - o.number;
    }
}
