package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinningLottoNos {

    private List<LottoNo> winningNumbers;
    private final LottoNo bonusNo;

    public WinningLottoNos(Set<Integer> numbers, int bonusNo ) {
        this.winningNumbers = new ArrayList<>();
        for( Integer number : numbers ) {
            this.winningNumbers.add(LottoNo.of(number));
        }
        this.bonusNo = LottoNo.of(bonusNo);
    }

    public static boolean checkValidationWinningLottoNos(Set<Integer> numbers, Integer bonusNo ) {
        if( !LottoTicket.checkValidationLottoTicket(numbers) || !LottoNo.checkValidationLottoNo(bonusNo) ) {
            return false;
        }
        return !numbers.contains(bonusNo);
    }

    public StatisticsType isWinning(LottoTicket lottoTicket) {
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
