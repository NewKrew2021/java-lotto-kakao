package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static final String DEFAULT_SPLIT_DELIMITER = ",";
    public static final String WHITE_SPACE = " ";
    public static final String BLANK = "";
    public static final String EXCEPTION_EMPTY_STRING = "문자열을 입력해주세요.";

    public static List<String> splitText(String inputText) {
        if (isEmpty(inputText)) {
            throw new IllegalArgumentException(EXCEPTION_EMPTY_STRING);
        }
        inputText = inputText.replaceAll(WHITE_SPACE, BLANK);
        return Arrays.asList(inputText.split(DEFAULT_SPLIT_DELIMITER));
    }

    private static boolean isEmpty(String inputText) {
        return inputText == null || inputText.trim().isEmpty();
    }
}
