package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoDto {

    private List<LottoTicket> lottoTickets;
    private Set<Integer> winningLottoOnlyNumbers;
    private int BonusNumber;
    private WinningLottoNos WinningLottoNos;

    public  List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void setLottoTickets( List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Set<Integer> getWinningLottoOnlyNumbers() {
        return winningLottoOnlyNumbers;
    }

    public void setWinningLottoOnlyNumbers(Set<Integer> winningLottoOnlyNumbers) {
        this.winningLottoOnlyNumbers = winningLottoOnlyNumbers;
    }

    public int getBonusNumber() {
        return BonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        BonusNumber = bonusNumber;
    }

    public lotto.domain.WinningLottoNos getWinningLottoNos() {
        return WinningLottoNos;
    }

    public void setWinningLottoNos(lotto.domain.WinningLottoNos winningLottoNos) {
        WinningLottoNos = winningLottoNos;
    }
}
