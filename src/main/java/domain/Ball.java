package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ball {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private final int number;

    public Ball(String number) {
        this(Integer.parseInt(number.trim()));
    }

    public Ball(int number) {
        if (!validator(number)) {
            throw new IllegalArgumentException("입력한 로또번호는 1~45 사이로 입력해야 합니다.");
        }
        this.number = number;
    }

    public static Ball map(String number) {
        return new Ball(number);
    }

    public static List<Ball> getBalls(String[] numbers){
        return Arrays.stream(numbers)
                .map(Ball::new)
                .collect(Collectors.toList());
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
