package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        LottoNo lottoNo = LottoNo.of(lottoNumber);

        boolean isContain = lottoTicket.isContains(lottoNo);

        assertThat(isContain).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6','7'"
    )
    void isContainsFalseTest(String ticketNumbers, Integer lottoNumber){
        LottoTicket lottoTicket = new LottoTicket(CsvParsing.convertStringToIntegerSet(ticketNumbers));
        LottoNo lottoNo = LottoNo.of(lottoNumber);

        boolean isContain = lottoTicket.isContains(lottoNo);

        assertThat(isContain).isFalse();
    }

}

