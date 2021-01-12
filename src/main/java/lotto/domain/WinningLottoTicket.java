package lotto.domain;

import lotto.StatisticsType;

import java.util.List;
import java.util.Set;

public class WinningLottoTicket {

    private final LottoTicket lottoTicket;
    private final LottoNo bonusNo;

    public WinningLottoTicket(Set<Integer> numbers, int bonusNo ) {
        this.lottoTicket = new LottoTicket(numbers);
        this.bonusNo = new LottoNo(bonusNo);
    }

    public static boolean checkValidationWinningLottoNos(Set<Integer> numbers, Integer bonusNo ) {
        if( !LottoTicket.checkValidationLottoTicket(numbers) || !LottoNo.checkValidationLottoNo(bonusNo) ) {
            return false;
        }
        return !numbers.contains(bonusNo);
    }

    public StatisticsType isWinning(LottoTicket lottoTicket) {
        int matchCount = this.lottoTicket.matchTickets(lottoTicket);
        boolean isBonusMatch = lottoTicket.isContains(bonusNo);
        return StatisticsType.matchTickets(matchCount, isBonusMatch);
    }

}
