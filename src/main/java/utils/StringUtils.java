package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static final String DEFAULT_SPLIT_DELIMITER = ",";
    public static final String WHITE_SPACE = " ";
    public static final String BLANK = "";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닌 입력이 포함되어 있습니다.";
    public static final String NOT_STRING_ERROR_MESSAGE = "문자열을 입력해주세요.";

    protected static List<String> splitText(String inputText) {
        if (isEmpty(inputText)) {
            throw new IllegalArgumentException(NOT_STRING_ERROR_MESSAGE);
        }
        inputText = inputText.replaceAll(WHITE_SPACE, BLANK);
        return Arrays.asList(inputText.split(DEFAULT_SPLIT_DELIMITER));
    }

    public static List<Integer> mapStringListToInteger(String inputText) {
        List<String> strings = splitText(inputText);
        List<Integer> results = new ArrayList<>();
        for (String string : strings) {
            addNumber(results, string);
        }
        return results;
    }

    private static void addNumber(List<Integer> numbers, String string) {
        try {
            numbers.add(Integer.parseInt(string));
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static boolean isEmpty(String inputText) {
        return inputText == null || inputText.trim().isEmpty();
    }
}
