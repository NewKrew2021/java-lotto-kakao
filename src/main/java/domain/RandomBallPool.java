package domain;

import domain.Ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomBallPool {

    private static List<Ball> randomPool;

    static {
        randomPool = new ArrayList<Ball>();
        for (int lottoNum = Ball.LOTTO_MIN; lottoNum <= Ball.LOTTO_MAX; ++lottoNum) {
            randomPool.add(new Ball(lottoNum));
        }
    }

    public static Ball getRandomNumber() {
        Collections.shuffle(randomPool);
        return randomPool.get(0);
    }
}
