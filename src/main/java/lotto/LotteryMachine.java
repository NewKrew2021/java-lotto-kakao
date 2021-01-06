package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LotteryMachine {
    public static final String SPLIT_DELIMITER = ",";
    public static final int MAX_VALUE = 45;
    public static final int MIN_VALUE = 1;

    Set<LottoNumber> winningNumber;
    LottoNumber bonusNumber;

    public LotteryMachine(String numbersText, int bonusNumber) {
        this.winningNumber = new HashSet<>();
        Arrays.stream(split(numbersText))
                .forEach(number -> winningNumber.add(LottoNumber.of(getParseInt(number))));

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

    public int raffle(Lotto lotto) {
        return getRank(getCount(lotto), getBonusCount(lotto));
    }

    private int getCount(Lotto lotto) {
        return (int) winningNumber.stream().filter(lottoNumber -> lotto.isContain(lottoNumber)).count();
    }

    private int getBonusCount(Lotto lotto) {
        return lotto.isContain(bonusNumber) ? 1 : 0;
    }

    private int getRank(int count, int bonusCount) {
        if (count == 6) {
            return 1;
        }
        if (count == 5 && bonusCount == 1) {
            return 2;
        }
        if (count == 5) {
            return 3;
        }
        if (count == 4) {
            return 4;
        }
        return 5;
    }
/*
12 = 1
11 = 2
10 = 3
8 = 4
6 = 5
 */
}