package domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private List<Ball> lottoBalls;

    public Lotto(){
        this(RandomBallPool.getLottoBallList(LOTTO_COUNT));
    }

    public Lotto(List<Ball> balls) {
        if(!validator(balls)){
            throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
        }
        lottoBalls = balls;
    }

    public List<Ball> getLottoBalls() {
        return lottoBalls;
    }

    public boolean hasBall(Ball ball) {
        return lottoBalls.contains(ball);
    }

    public boolean contains(Ball ball){
        return lottoBalls.contains(ball);
    }

    @Override
    public String toString() {
        StringBuilder lottoBuilder = new StringBuilder();
        lottoBuilder.append("[");

        for (Ball ball : lottoBalls) {
            lottoBuilder.append(ball);
            lottoBuilder.append(", ");
        }

        lottoBuilder.delete(lottoBuilder.length() - 2, lottoBuilder.length() - 1);
        lottoBuilder.append("]");
        return lottoBuilder.toString();
    }

    private boolean validator(List<Ball> balls) {
        if (balls.stream().distinct().count() != LOTTO_COUNT) {
            return false;
        }

        return true;
    }
}
