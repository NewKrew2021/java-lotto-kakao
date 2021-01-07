package lotto;

import java.util.*;

public class RandomGenerateStrategy implements GenerateStrategy {
    private static final int COUNT_OF_NUMBERS = 6;
    public static final int BOUND = 45;

    @Override
    public List<String> generate() {
        Set<String> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < COUNT_OF_NUMBERS) {
            int randomNumber = new Random().nextInt(BOUND) + 1;
            randomNumbers.add(String.valueOf(randomNumber));
        }

        return new ArrayList<>(randomNumbers);
    }
}
