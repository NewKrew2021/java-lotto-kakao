package lotto.domain;

import java.util.Set;

public class Validation {

    public static boolean validateLottoNo(final Integer number) {
        return number >= LottoNo.MIN_NUMBER && number <= LottoNo.MAX_NUMBER;
    }

    public static boolean validateLottoTicket(final Set<Integer> numbers) {
        return numbers.size() == LottoTicket.LOTTO_NUMBER_COUNT_OF_TICKET;
    }

    public static boolean validateWinningLottoNos(Set<Integer> numbers, Integer bonusNo ) {
        if( !validateLottoTicket(numbers) || !Validation.validateLottoNo(bonusNo) ) {
            return false;
        }
        return !numbers.contains(bonusNo);
    }

}
