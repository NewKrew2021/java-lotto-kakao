package lotto.util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int getRandomValue() {
        return random.nextInt(44) + 1;
    }

}
