package domain;

import utils.RandomBallPool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private List<Ball> lottoBalls;

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

    public static Lotto makeAutoLotto(){
        Set<Ball> balls = new HashSet<>();

        while(balls.size() != LOTTO_COUNT){
            balls.add(RandomBallPool.getRandomNumber());
        }

        return Lotto.makeLotto(balls
                .stream()
                .collect(Collectors.toList()));
    }

    public static Lotto makeLotto(List<Ball> balls){
        return new Lotto(balls);
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
