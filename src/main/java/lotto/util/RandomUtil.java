package lotto.util;

import lotto.domain.LottoFixedValue;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int getRandomValue() {
        return random.nextInt(LottoFixedValue.LOTTO_MAX_INT - 1) + 1;
    }

}
