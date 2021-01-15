package domain;

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

    public static List<Ball> getRandomBalls(int ballCount) {
        List<Ball> randomBalls = new ArrayList<Ball>();
        Collections.shuffle(randomPool);

        for (int i = 0; i < ballCount; i++) {
            randomBalls.add(randomPool.get(i));
        }

        return randomBalls;
    }


}
