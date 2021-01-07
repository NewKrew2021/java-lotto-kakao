package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class WinningNumber {
    Set<LottoNumber> winningNumber;

    public WinningNumber(Set<LottoNumber> winningNumber){
        this.winningNumber = Collections.unmodifiableSet(winningNumber);
    }

    public Set<LottoNumber> getWinningNumber(){
        return getWinningNumber();
    }

    public int matchCount(Lotto lotto) {
        return (int) winningNumber.stream().filter(lottoNumber -> lotto.isContain(lottoNumber)).count();
    }
}
