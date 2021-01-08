package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator implements LottoNumberGenerator {
    private static final int MINIMUM_LIMIT = 1;
    private static final int MAXIMUM_LIMIT = 45;
    private static final int SIZE = 6;
    private static final Random random = new Random();

    public Set<Integer> generateNumbers(){
        Set<Integer> integers = new HashSet<>();

        for(int i = 0; i < SIZE; i++){
            int nextVal = getOtherInt(integers);
            integers.add(nextVal);
        }

        return integers;
    }

    private int getOtherInt(Set<Integer> integers){
        int number;

        do{
            number = random.nextInt(MAXIMUM_LIMIT + 1 - MINIMUM_LIMIT) + MINIMUM_LIMIT;
        }while(integers.contains(number));

        return number;
    }
}
