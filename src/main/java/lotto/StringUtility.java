package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtility {

    public static List<Integer> StringToIntegerList(String input) {
        return Arrays.stream(preProcessing(input).split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String preProcessing(String input) {
        return input.replaceAll(" ", "");
    }

}
