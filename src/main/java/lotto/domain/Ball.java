package lotto.domain;

import java.util.Objects;

public class Ball implements Comparable<Ball> {

    private final int ballNumber;

    public Ball(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public static Ball createBall(String ballString){
        return BallFactory.getBall(ballString);
    }

    public boolean isDuplicated(Lotto lotto) {
        return lotto.contains(this);
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

    @Override
    public int compareTo(Ball o) {
        return this.ballNumber - o.ballNumber;
    }
}
