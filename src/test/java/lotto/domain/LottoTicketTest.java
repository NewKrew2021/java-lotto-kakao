package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {

    @ParameterizedTest
    @CsvSource(
            value = "1,2,3,4,5,6 | 5", delimiter = '|'
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

