package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.LottoTicket.LOTTO_TICKET_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoTicketTest {

    @DisplayName("중복되지 않은 6개의 로또 넘버가 주어 졌을 때 로또 티켓을 생성한다.")
    @Test
    void create() {
        //given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @DisplayName("중복된 숫자가 있는 6개의 로또 넘버가 주어 졌을 때 로또 티켓을 생성하면 예외가 발생된다.")
    @Test
    void valid() {
        //given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage(LOTTO_TICKET_EXCEPTION_MESSAGE);
    }

    @DisplayName("6개 미만의 로또 넘버가 주어 졌을 때 로또 티켓을 생성하면 예외가 발생된다.")
    @Test
    void validLength1() {
        //given
        NumberGenerateStrategy lessLengthStrategy = () -> Arrays.asList(1, 2, 3, 4, 5);

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> LottoTicket.from(lessLengthStrategy))
                .withMessage(LOTTO_TICKET_EXCEPTION_MESSAGE);
    }

    @DisplayName("6개 초과의 로또 넘버가 주어 졌을 때 로또 티켓을 생성하면 예외가 발생된다.")
    @Test
    void validLength2() {
        //given
        NumberGenerateStrategy overLengthStrategy = () -> Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> LottoTicket.from(overLengthStrategy))
                .withMessage(LOTTO_TICKET_EXCEPTION_MESSAGE);
    }
}
