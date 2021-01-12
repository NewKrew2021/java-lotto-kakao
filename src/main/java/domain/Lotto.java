package domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private List<Ball> lottoBalls;

    public Lotto(){
        lottoBalls = RandomBallPool.getLottoBallList(LOTTO_COUNT);
    }

    public Lotto(List<Ball> balls) {
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
}
