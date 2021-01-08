package domain;


import exception.InvalidNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoConstant.LOTTO_MAX_NUMBER;
import static domain.LottoConstant.LOTTO_MIN_NUMBER;

public class Number implements Comparable<Number> {
    private final int number;
    private static List<Number> numbers = IntStream
            .rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(Number::new)
            .collect(Collectors.toList());

    private Number(int number) {
        this.number = number;
    }

    public static Number getNumber(int number) {
        checkValidNumber(number);
        return numbers.get(number - 1);
    }

    private static void checkValidNumber(int number) {
        if (number < LOTTO_MIN_NUMBER ||
                number > LOTTO_MAX_NUMBER) {
            throw new InvalidNumberException(number);
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
