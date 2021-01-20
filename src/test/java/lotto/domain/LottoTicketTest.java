package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("로또 티켓 테스트")
public class LottoTicketTest {

    @ParameterizedTest
    @CsvSource(
            value = "1,2,3,4,5,6 | 5", delimiter = '|'
    )
    @DisplayName("티켓에 번호가 포함되어있는지 여부 확인 true 반환 테스트")
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
    @DisplayName("티켓에 번호가 포함되어있는지 여부 확인 false 반환 테스트")
    void isContainsFalseTest(String ticketNumbers, Integer lottoNumber){
        LottoTicket lottoTicket = new LottoTicket(CsvParsing.convertStringToIntegerSet(ticketNumbers));
        LottoNo lottoNo = new LottoNo(lottoNumber);

        boolean isContain = lottoTicket.isContains(lottoNo);

        assertThat(isContain).isFalse();
    }

}

