package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    private Splitter() {
        throw new IllegalStateException("Utility Class!!");
    }

    public static List<Integer> splitToNumberBy(String string, String delimiter) {
        string = string.replace(" ", "");
        int[] numbers = Arrays.stream(string.split(delimiter)).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
