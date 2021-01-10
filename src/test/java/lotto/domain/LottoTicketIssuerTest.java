package lotto.domain;

import lotto.domain.dto.InsertPrice;
import lotto.domain.dto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketIssuerTest {
    @Test
    void testIssue() {
        LottoTicketIssuer issuer = new LottoTicketIssuer(new InsertPrice(2000));
        LottoTickets tickets = issuer.issue(() -> Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList()));

        assertThat(tickets).isEqualTo(new LottoTickets(Arrays.asList(
                new LottoNumbers(customLottoNumbers(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(customLottoNumbers(1, 2, 3, 4, 5, 6))
        )));
    }

    @DisplayName("잔돈을 올바르게 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"0,0", "999,999", "1000,0", "1001,1"})
    void testGetChange(int price, int expected) {
        LottoTicketIssuer issuer = new LottoTicketIssuer(new InsertPrice(price));
        assertThat(issuer.getChange()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "999,0", "1000,1000", "1001,1000"})
    void testGetInvestedMoney(int price, int expected) {
        LottoTicketIssuer issuer = new LottoTicketIssuer(new InsertPrice(price));
        assertThat(issuer.getInvestedMoney()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "999,0", "1000,1", "1001,1", "5000,5"})
    void testGetTicketCount(int price, int expected) {
        LottoTicketIssuer issuer = new LottoTicketIssuer(new InsertPrice(price));
        assertThat(issuer.getTicketCount()).isEqualTo(expected);
    }

    private List<LottoNumber> customLottoNumbers(int... parameters) {
        return Arrays.stream(parameters)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
