package domain;

import domain.exceptions.InvalidLottoNumberException;

import java.util.Objects;

public class LottoWinningNumber {

    private final LottoTicket lottoWinningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        validate(lottoWinningTicket, bonusNumber);
        this.lottoWinningTicket = lottoWinningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        if(lottoWinningTicket.isContains(bonusNumber)) {
            throw new InvalidLottoNumberException();
        }
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
