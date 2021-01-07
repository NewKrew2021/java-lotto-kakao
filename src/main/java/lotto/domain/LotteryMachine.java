package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LotteryMachine {
    public static final String SPLIT_DELIMITER = ",";
    public static final int MAX_VALUE = 45;
    public static final int MIN_VALUE = 1;

    WinningNumber winningNumber;
    LottoNumber bonusNumber;

    public LotteryMachine(String numbersText, int bonusNumber) {
        this.winningNumber = new WinningNumber(Arrays.stream(split(numbersText))
                .map(number -> LottoNumber.of(getParseInt(number)))
                .collect(Collectors.toSet()));
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private int getParseInt(String number) {
        int num = Integer.parseInt(number);
        if (num > MAX_VALUE || num < MIN_VALUE) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        return num;
    }

    private String[] split(String numbersText) {
        return numbersText.split(SPLIT_DELIMITER);
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}