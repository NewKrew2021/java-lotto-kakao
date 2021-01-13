package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersSplitAndParser {
    public static List<Integer> parseToIntegers(String input) {
        return Stream.of(input.split(","))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList());
    }
}
