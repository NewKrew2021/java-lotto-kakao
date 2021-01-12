package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTicketTest {

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,3,5|1,2,3,4,5,5|1,2,3,4,5,6'"
    )
    void checkValidationLottoTicketTest(String input){
        List<Set<Integer>> ticketsNumber = CsvParsing.convertStringToTicketsNumber(input);

        boolean invalidNumberSize = LottoTicket.checkValidationLottoTicket(ticketsNumber.get(0));
        boolean invalidDuplication = LottoTicket.checkValidationLottoTicket(ticketsNumber.get(1));
        boolean validNumber = LottoTicket.checkValidationLottoTicket(ticketsNumber.get(2));

        assertThat(invalidNumberSize).isFalse();
        assertThat(invalidDuplication).isFalse();
        assertThat(validNumber).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6','5'"
    )
    void isContainsTrueTest(String ticketNumbers, Integer lottoNumber){
        LottoTicket lottoTicket = new LottoTicket(CsvParsing.convertStringToIntegerSet(ticketNumbers));
        LottoNo lottoNo = new LottoNo(lottoNumber);

        boolean isContain = lottoTicket.isContains(lottoNo);

        assertThat(isContain).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6','7'"
    )
    void isContainsFalseTest(String ticketNumbers, Integer lottoNumber){
        LottoTicket lottoTicket = new LottoTicket(CsvParsing.convertStringToIntegerSet(ticketNumbers));
        LottoNo lottoNo = new LottoNo(lottoNumber);

        boolean isContain = lottoTicket.isContains(lottoNo);

        assertThat(isContain).isFalse();
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6'," +
            "'7,8,9,10,11,12|6,7,8,9,10,11|5,6,7,8,9,10|4,5,6,7,8,9|3,4,5,6,7,8|2,3,4,5,6,7|1,2,3,4,5,6'"
    )
    void matchTicketTest(String ticketNumbers, String ticketsNumbers){
        LottoTicket winningTicket = new LottoTicket(CsvParsing.convertStringToIntegerSet(ticketNumbers));
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Set<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);

        for( Set<Integer> ticket : ticketsNumberListInt ) {
            lottoTickets.add(new LottoTicket(ticket));
        }

        for (int i = 0; i < 7; i++) {
            int matchCount = winningTicket.matchTickets(lottoTickets.get(i));
            assertThat(matchCount).isEqualTo(i);
        }
    }

}

