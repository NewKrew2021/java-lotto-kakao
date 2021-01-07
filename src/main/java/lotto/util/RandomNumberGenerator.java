package lotto.util;

import java.util.*;

public class RandomNumberGenerator implements LottoNumberGenerator {

    public static final int RANGE = 45;

    public List<Integer> getNumbers() {
        Set<Integer> numbers = new TreeSet<>();
        Random random = new Random();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(RANGE) + 1);
        }
        return new ArrayList<>(numbers);
    }
}
