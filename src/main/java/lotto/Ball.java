package lotto;

import java.util.Objects;

public class Ball {

    private int ballNumber;

    public Ball(String ballString) {
        int ball = 0;
        try{
            ball = Integer.parseInt(ballString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("볼은 정수여야 한다.");
        }
        checkRange(ball);
        this.ballNumber = ball;
    }

    public void checkRange(int ballNumber){
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
