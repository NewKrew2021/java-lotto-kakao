package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Splitter {

    private Splitter() {
        throw new IllegalStateException();
    }

    public static List<Integer> splitToNumberBy(String string, String delimiter) {
        string = string.replace(" ", "");
        return Stream.of(string.split(delimiter))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
