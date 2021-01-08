package lotto;

import java.util.InputMismatchException;
import java.util.Objects;

public class Ball implements Comparable<Ball> {

    private final int ballNumber;

    public Ball(String ballString) {
        int ballNumber = checkInteger(ballString);
        checkRange(ballNumber);
        this.ballNumber = ballNumber;
    }

    public int checkInteger(String ballString){
        int ballNumber = 0;
        try {
            ballNumber = Integer.parseInt(ballString);
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("볼은 정수여야 한다.");
        }
        return ballNumber;
    }

    public void checkRange(int ballNumber) {
        if(outOfRange(ballNumber)){
            throw new IllegalArgumentException("볼은 1 이상 45 이하여야 한다.");
        }
    }

    public boolean outOfRange(int ballNumber){
        return 1 > ballNumber || ballNumber > 45;
    }

    public boolean isDuplicated(Lotto lotto){
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
