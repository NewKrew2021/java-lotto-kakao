package lotto.domain;

import lotto.StatisticsType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class WinningLottoTicketTest {

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6|1,2,3,4,5,6|1,2,3,4,5,6|1,2,3,4,5,5|1,2,3,4,5,6'," +
            "'3,0,46,0,7'"
    )
    void checkValidationTest(String ticketsNumbers, String bonusNumbers) {
        List<Set<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);
        List<Integer> bonusNumbersIntList = CsvParsing.convertStringToIntegerList(bonusNumbers);

        boolean invalid0 = WinningLottoTicket.checkValidationWinningLottoNos(ticketsNumberListInt.get(0), bonusNumbersIntList.get(0));
        boolean invalid1 = WinningLottoTicket.checkValidationWinningLottoNos(ticketsNumberListInt.get(1), bonusNumbersIntList.get(1));
        boolean invalid2 = WinningLottoTicket.checkValidationWinningLottoNos(ticketsNumberListInt.get(2), bonusNumbersIntList.get(2));
        boolean invalid3 = WinningLottoTicket.checkValidationWinningLottoNos(ticketsNumberListInt.get(3), bonusNumbersIntList.get(3));
        boolean valid = WinningLottoTicket.checkValidationWinningLottoNos(ticketsNumberListInt.get(4), bonusNumbersIntList.get(4));

        assertThat(invalid0).isFalse();
        assertThat(invalid1).isFalse();
        assertThat(invalid2).isFalse();
        assertThat(invalid3).isFalse();
        assertThat(valid).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6'," +
            "'7'," +
            "'1,2,9,10,11,12|1,2,3,9,10,11|1,2,3,4,8,9|1,2,3,4,5,8|1,2,3,4,5,7|1,2,3,4,5,6'"
    )
    void isWinningTest(String winningLottoNumbers, int bonusNumber, String ticketsNumbers) {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(CsvParsing.convertStringToIntegerSet(winningLottoNumbers), bonusNumber);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Set<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);

        for( Set<Integer> ticket : ticketsNumberListInt ) {
            lottoTickets.add(new LottoTicket(ticket));
        }

        StatisticsType none = winningLottoTicket.isWinning(lottoTickets.get(0));
        StatisticsType three = winningLottoTicket.isWinning(lottoTickets.get(1));
        StatisticsType four = winningLottoTicket.isWinning(lottoTickets.get(2));
        StatisticsType five = winningLottoTicket.isWinning(lottoTickets.get(3));
        StatisticsType fiveWithBonus = winningLottoTicket.isWinning(lottoTickets.get(4));
        StatisticsType six = winningLottoTicket.isWinning(lottoTickets.get(5));

        assertThat(none).isEqualTo(StatisticsType.NONE);
        assertThat(three).isEqualTo(StatisticsType.THREE);
        assertThat(four).isEqualTo(StatisticsType.FOUR);
        assertThat(five).isEqualTo(StatisticsType.FIVE);
        assertThat(fiveWithBonus).isEqualTo(StatisticsType.FIVE_WITH_BONUS);
        assertThat(six).isEqualTo(StatisticsType.SIX);
    }

}
