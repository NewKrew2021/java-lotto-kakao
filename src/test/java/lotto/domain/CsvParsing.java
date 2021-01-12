package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CsvParsing {

    public static List<Integer> convertStringToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static Set<Integer> convertStringToIntegerSet(String numbers) {
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }

    public static List<Set<Integer>> convertStringToTicketsNumber(String numbers) {
        return Arrays.stream(numbers.split("[|]"))
                .map(s -> Arrays.stream(s.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toSet())
                ).collect(Collectors.toList());
    }

}
