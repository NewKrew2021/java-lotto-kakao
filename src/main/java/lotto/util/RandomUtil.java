package lotto.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();
    private static final int LOTTO_PRICE = 1000;

    public static int getRandomValue() {
        return random.nextInt(LOTTO_PRICE - 1) + 1;
    }

}
