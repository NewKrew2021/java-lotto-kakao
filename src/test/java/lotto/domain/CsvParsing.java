package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParsing {

    public static List<Integer> convertStringToIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> convertStringToTicketsNumber(String numbers) {
        return Arrays.stream(numbers.split("[|]"))
                .map(s -> Arrays.stream(s.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList())
                ).collect(Collectors.toList());
    }

}
