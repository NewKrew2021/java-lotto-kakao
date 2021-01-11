package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomBallPool {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private static List<Integer> randomPool;

    static {
        randomPool = new ArrayList<>();
        for (int lottoNum = LOTTO_MIN; lottoNum <= LOTTO_MAX; ++lottoNum) {
            randomPool.add(lottoNum);
        }
    }

    public static List<Integer> getLottoBallList(int count){
        Collections.shuffle(randomPool);
        return randomPool.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
