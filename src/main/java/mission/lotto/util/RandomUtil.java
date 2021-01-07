package mission.lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtil {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> numberList = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
                                                             .boxed()
                                                             .collect(Collectors.toList());

    public static List<Integer> getRandomSixIntegerList() {
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }

}
