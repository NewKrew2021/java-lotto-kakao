package lotto.domain;


public class Number implements Comparable<Number> {
    private final int number;
    private static final int BOUNDARY_START_NUM = 1;
    private static final int BOUNDARY_END_NUM = 45;


    public Number(int number) {
        checkValidNumber(number);
        this.number = number;
    }

    private void checkValidNumber(int number) {
        if (BOUNDARY_START_NUM > number || number > BOUNDARY_END_NUM) {
            throw new InvalidNumberException();
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
