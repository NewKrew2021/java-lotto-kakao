package lotto.util;

import java.util.*;

public class RandomNumberGenerator implements LottoNumberGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUM_OF_NUMBERS = 6;
    private static final List<Integer> allNumbers;

    static{
        allNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(i);
        }
    }

    public Set<Integer> getNumbers() {
        Collections.shuffle(allNumbers);
        return new HashSet<>(allNumbers.subList(0, NUM_OF_NUMBERS));
    }
}
