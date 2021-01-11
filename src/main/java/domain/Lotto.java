package domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private List<Integer> lottoBalls;

    public Lotto(){
        lottoBalls = RandomBallPool.getLottoBallList(LOTTO_COUNT);
    }

    public Lotto(List<Integer> balls) {
        lottoBalls = balls;
    }

    public List<Integer> getLottoBalls() {
        return lottoBalls;
    }

    public boolean hasBall(int ball) {
        return lottoBalls.contains(ball);
    }


    public boolean contains(int ball){
        return lottoBalls.contains(ball);
    }

    @Override
    public String toString() {
        StringBuilder lottoBuilder = new StringBuilder();
        lottoBuilder.append("[");

        for (int ball : lottoBalls) {
            lottoBuilder.append(ball);
            lottoBuilder.append(", ");
        }

        lottoBuilder.delete(lottoBuilder.length() - 2, lottoBuilder.length() - 1);
        lottoBuilder.append("]");
        return lottoBuilder.toString();
    }
}
