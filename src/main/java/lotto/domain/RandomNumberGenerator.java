package lotto.domain;

import java.util.*;

public class RandomNumberGenerator {
    private static final int MINIMUM_LIMIT = 1;
    private static final int MAXIMUM_LIMIT = 45;
    private static final int SIZE = 6;
    private final List<Integer> availableNumbers;

    public RandomNumberGenerator(){
        this.availableNumbers = new ArrayList<>();
        for(int i = MINIMUM_LIMIT; i <= MAXIMUM_LIMIT; i++){
            availableNumbers.add(i);
        }
    }

    public Set<Integer> generateNumbers(){
        Collections.shuffle(availableNumbers);
        Set<Integer> numbers = new HashSet<>();
        for(int i = 0; i < SIZE; i++){
            numbers.add(availableNumbers.get(i));
        }

        return numbers;
    }

}
