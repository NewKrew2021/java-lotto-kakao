package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Ball implements Comparable<Ball> {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private static final Map<Integer, Ball> balls = new HashMap<>();
    private static final String BALL_TYPE_EXCEPTION_MESSAGE = "볼은 정수여야 한다.";
    private static final String BALL_RANGE_EXCEPTION_MESSAGE = "볼은 %d 이상 %d 이하여야 한다.";
    private final int ballNumber;

    static {
        IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
                .forEach(ballNumber -> balls.put(ballNumber, new Ball(ballNumber)));
    }

    public Ball(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public static Ball of(String ballText) {
        int ballNumber;

        try {
            ballNumber = Integer.parseInt(ballText);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(BALL_TYPE_EXCEPTION_MESSAGE);
        }

        return of(ballNumber);
    }

    public static Ball of(int ballNumber) {
        checkRange(ballNumber);
        return balls.get(ballNumber);
    }

    private static void checkRange(int ballNumber) {
        if (ballNumber < LOWER_BOUND || ballNumber > UPPER_BOUND) {
            throw new IllegalArgumentException(String.format(BALL_RANGE_EXCEPTION_MESSAGE, LOWER_BOUND, UPPER_BOUND));
        }
    }

    @Override
    public int compareTo(Ball o) {
        return this.ballNumber - o.ballNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
