package lotto;

import java.util.List;
import java.util.Objects;

public class WinningNumberSet {
    private Lotto winningLotto;
    private Ball bonusBall;

    public WinningNumberSet(String lottoString, String bonusBallString){
        winningLotto = new Lotto(lottoString);
        bonusBall = new Ball(bonusBallString);
        if(bonusBall.isDuplicated(winningLotto)){
            throw new IllegalArgumentException("보너스볼에는 당첨 번호가 포함되어서는 안된다.");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumberSet that = (WinningNumberSet) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusBall);
    }
}
