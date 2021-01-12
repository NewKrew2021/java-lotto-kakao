package lotto.domain;

import lotto.util.LottoNumberParser;

import java.util.Collections;
import java.util.Set;

public class WinningNumber {

    Set<LottoNumber> winningNumber;

    private WinningNumber(Set<LottoNumber> winningNumber){
        this.winningNumber = Collections.unmodifiableSet(winningNumber);
    }

    public static WinningNumber fromNumbersText(String numbersText) {
        return new WinningNumber(
                LottoNumberParser.toLottoNumbers(numbersText));
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return winningNumber.contains(lottoNumber);
    }
}
