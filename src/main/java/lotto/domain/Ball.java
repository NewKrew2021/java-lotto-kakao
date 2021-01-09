package lotto.domain;

import java.util.Objects;

public class Ball implements Comparable<Ball> {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private final int ballNumber;

    public Ball(String ballString) {
        int ball;

        try {
            ball = Integer.parseInt(ballString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("볼은 정수여야 한다.");
        }

        checkRange(ball);
        this.ballNumber = ball;
    }

    private void checkRange(int ballNumber) {
        if (ballNumber < LOWER_BOUND || ballNumber > UPPER_BOUND) {
            throw new IllegalArgumentException("볼은 1 이상 45 이하여야 한다.");
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
