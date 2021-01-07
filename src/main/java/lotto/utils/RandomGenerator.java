package lotto.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {
    private static final Random random = new Random();

    public static Set<Integer> nonDuplicatedInt(int minimumLimit, int maximumLimit, int size){

        Set<Integer> integers = new HashSet<>();

        for(int i = 0; i < size; i++){
            int nextVal = getOtherInt(integers, minimumLimit, maximumLimit);
            integers.add(nextVal);
        }

        return integers;
    }

    private static int getOtherInt(Set<Integer> integers, int minimumLimit, int maximumLimit){
        int number;

        do{
            number = random.nextInt(maximumLimit + 1 - minimumLimit) + minimumLimit;
        }while(integers.contains(number));

        return number;
    }

}


