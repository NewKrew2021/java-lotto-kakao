package lotto.domain;

import java.util.*;

public class RandomNo {
    private static final int MAX_LENGTH = 45;
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = 1; i <= MAX_LENGTH; ++i) {
            numbers.add(i);
        }
    }

    public static List<Integer> generateRandomNos(int length) {
        Collections.shuffle(numbers);
        return numbers.subList(0, length);
    }
}
