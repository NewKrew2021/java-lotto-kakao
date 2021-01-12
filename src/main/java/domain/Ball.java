package domain;

import java.util.Objects;

public class Ball {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private final int number;

    public Ball(String number) {
        this(Integer.parseInt(number));
    }

    public Ball(int number) {
        if (!validator(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static Ball map(String number) {
        return new Ball(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    private boolean validator(int number) {
        if (number < LOTTO_MIN || LOTTO_MAX < number) {
            return false;
        }

        return true;
    }
}
