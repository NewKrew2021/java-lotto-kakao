package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Splitter {

    private static final String ILLEGAL_LOTTO_INPUT_MESSAGE = "잘못된 입력입니다. 6개의 로또번호를 , 로 구분하여 입력해주세요.";

    private Splitter() {
        throw new IllegalStateException("Utility Class!!");
    }

    public static List<Integer> splitToNumberBy(String string, String delimiter) {
        string = string.replace(" ", "");
        return Stream.of(string.split(delimiter))
                .mapToInt(Splitter::wrapToInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int wrapToInt(String number) {
        int res;
        try {
            res = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_INPUT_MESSAGE);
        }
        return res;
    }
}
