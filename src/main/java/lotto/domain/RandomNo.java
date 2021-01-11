package lotto.domain;

import java.util.*;

public class RandomNo {
    private static final int MAX_LENGTH = 45;
    private static final List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int i = 1; i <= MAX_LENGTH; ++i) {
            numbers.add(new LottoNumber(i));
        }
    }

    public static List<LottoNumber> generateRandomNos(int length) {
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0, length));
    }
}
