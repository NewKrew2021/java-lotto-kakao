package lotto.domain;

import lotto.util.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinningLottoNos {

    private List<LottoNo> winningNumbers;
    private final LottoNo bonusNo;

    public WinningLottoNos(Set<Integer> numbers, int bonusNo ) {
        if(!Validation.validateWinningLottoNos(numbers, bonusNo)) {
            throw new IllegalArgumentException("잘못된 로또 당첨 번호입니다.");
        }

        this.winningNumbers = new ArrayList<>();
        for( Integer number : numbers ) {
            this.winningNumbers.add(LottoNo.of(number));
        }
        this.bonusNo = LottoNo.of(bonusNo);
    }

    public StatisticsType rankWinning(LottoTicket lottoTicket) {
        int matchCount = this.matchTickets(lottoTicket);
        boolean isBonusMatch = lottoTicket.isContains(bonusNo);
        return StatisticsType.matchTickets(matchCount, isBonusMatch);
    }

    public int matchTickets(LottoTicket lottoTicket) {
        return (int) this.winningNumbers.stream()
                .filter(lottoTicket::isContains)
                .count();
    }


}
