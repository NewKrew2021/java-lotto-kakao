package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberParser {
    public static final String SPLIT_DELIMITER = ",";
    public static final int NUM_OF_NUMBERS = 6;

    public static Set<LottoNumber> toLottoNumbers(String numbersText) {
        Set<LottoNumber> lottoNumbers = trim(split(numbersText)).stream()
                .map(number -> LottoNumber.of(getParseInt(number)))
                .collect(Collectors.toSet());
        validate(lottoNumbers);
        return lottoNumbers;
    }

    private static int getParseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    private static String[] split(String numbersText) {
        return numbersText.split(SPLIT_DELIMITER);
    }

    private static List<String> trim(String[] splitTexts) {
        return Arrays.stream(splitTexts)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUM_OF_NUMBERS) {
            throw new IllegalArgumentException("로또 번호를 중복 없이 6개 입력해주세요.");
        }
    }
}
