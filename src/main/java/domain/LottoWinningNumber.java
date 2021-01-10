package domain;

import domain.exceptions.InvalidLottoNumberException;

import java.util.List;
import java.util.Objects;

public class LottoWinningNumber {

    private final Lotto lottoWinningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(Lotto lottoWinningTicket, LottoNumber bonusNumber) {
        validate(lottoWinningTicket, bonusNumber);
        this.lottoWinningTicket = lottoWinningTicket;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumber of(List<Integer> numbers, int bonusNumber){
        return new LottoWinningNumber(Lotto.ofIntegerNumber(numbers), new LottoNumber(bonusNumber));
    }

    private void validate(Lotto lottoWinningTicket, LottoNumber bonusNumber) {
        if (lottoWinningTicket.isContains(bonusNumber)) {
            throw new InvalidLottoNumberException("보너스 번호는 중복이 될 수 없습니다.");
        }
    }

    public int getMatchedCount(Lotto lotto) {
        return lotto.getMatchedCount(lottoWinningTicket);
    }

    public boolean isContainsBounusNumber(Lotto lotto) {
        return lotto.isContains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningNumber that = (LottoWinningNumber) o;
        return bonusNumber == that.bonusNumber && Objects.equals(lottoWinningTicket, that.lottoWinningTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningTicket, bonusNumber);
    }
}
