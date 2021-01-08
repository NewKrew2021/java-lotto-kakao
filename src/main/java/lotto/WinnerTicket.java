package lotto;

import java.util.List;

public class WinnerTicket {
    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public WinnerTicket(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerTicket of(List<Integer> winnerNumbers, int bonusNumber) {
        LottoNumbers lottoNumbers = LottoNumbers.from(new ManualInputStrategy(winnerNumbers));
        return new WinnerTicket(lottoNumbers, new LottoNumber(bonusNumber));
    }

    public LottoNumbers getWinnerNumbers() {
        return winnerNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public int countMatchingNumber(LottoNumbers lottoNumbers) {
        return winnerNumbers.countMatchingNumber(lottoNumbers);
    }

    public boolean hasBonus(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
