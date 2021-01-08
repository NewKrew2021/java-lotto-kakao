package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {
    public static final String SPLIT_DELIMITER = ", ";
    public static final int NUM_OF_NUMBERS = 6;

    Set<LottoNumber> winningNumber;

    private WinningNumber(Set<LottoNumber> winningNumber){
        this.winningNumber = Collections.unmodifiableSet(winningNumber);
    }

    public static WinningNumber fromNumbersText(String numbersText) {
        return new WinningNumber(Arrays.stream(split(numbersText))
                .map(number -> LottoNumber.of(getParseInt(number)))
                .collect(Collectors.toSet()));
    }

    private static int getParseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    private static String[] split(String numbersText) {
        String[] splitText = numbersText.split(SPLIT_DELIMITER);
        if (splitText.length != NUM_OF_NUMBERS) {
            throw new IllegalArgumentException("로또 번호를 6개 입력해주세요.");
        }
        return splitText;
    }

    public Set<LottoNumber> getWinningNumber(){
        return getWinningNumber();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return winningNumber.contains(lottoNumber);
    }
}
