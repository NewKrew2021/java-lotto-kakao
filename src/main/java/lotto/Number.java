package lotto;


public class Number implements Comparable<Number> {
    private final int number;

    public Number(int number) {
        checkValidNumber(number);
        this.number = number;
    }

    private void checkValidNumber(int number) {
        if (1 > number || number > 45) {
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
