package lotto.util;

import java.util.*;

public class RandomNumberGenerator implements LottoNumberGenerator {

    public static final int RANGE = 45;
    public static final int NUM_OF_NUMBERS = 6;

    public Set<Integer> getNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < NUM_OF_NUMBERS) {
            numbers.add(random.nextInt(RANGE) + 1);
        }
        return numbers;
    }
}
