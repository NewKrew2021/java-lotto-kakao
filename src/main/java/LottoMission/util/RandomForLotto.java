package LottoMission.util;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomForLotto {

    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 45;
    private static final List<Integer> numberList = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toList());

    private static final Random random = new Random();

    public static int getRandomInt() {
        return random.nextInt((MAX_NUMBER_VALUE - MIN_NUMBER_VALUE + 1)) + MIN_NUMBER_VALUE;
    }

    public static List<Integer> getRandomSixIntegerList() {
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }
}
