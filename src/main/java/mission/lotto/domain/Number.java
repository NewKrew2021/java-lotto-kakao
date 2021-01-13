package mission.lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Number {

    public static final int MIN_NUMBER_VALUE = 1;
    public static final int MAX_NUMBER_VALUE = 45;
    private static final Map<Integer, Number> numberPool;

    static {
        numberPool = IntStream.range(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE + 1)
                .mapToObj(Number::new)
                .collect(Collectors.toMap(Number::getNumber, Function.identity()));
    }

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("숫자는 1~45 에 포함 되어야 합니다");
        }
        return numberPool.get(number);
    }

    private static boolean isInvalidNumber(int number) {
        return number > MAX_NUMBER_VALUE || number < MIN_NUMBER_VALUE;
    }

    private int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
