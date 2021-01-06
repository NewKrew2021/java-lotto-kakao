package lotto;

import java.util.*;

public class RandomNumberGenerator implements LottoNumberGenerator {

    public static final int RANGE = 45;

    public List<Integer> getNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(RANGE));
        }
        return new ArrayList<>(numbers);
    }
}
