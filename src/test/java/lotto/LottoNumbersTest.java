package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.LottoNumbers.LOTTO_TICKET_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoNumbersTest {

    @DisplayName("숫자를 생성하는 전략이 주어 졌을 때 로또 티켓을 생성한다.")
    @Test
    void create() {
        //given
        NumberGenerateStrategy strategy = new OneToSixGenerator();

        //when
        LottoNumbers lottoNumbers = LottoNumbers.from(strategy);

        //then
        List<LottoNumber> expected = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(expected);
    }

    @DisplayName("중복된 숫자가 있는 6개의 로또 넘버가 주어 졌을 때 로또 티켓을 생성하면 예외가 발생된다.")
    @Test
    void valid() {
        //given
        NumberGenerateStrategy duplicateStrategy = () -> Arrays.asList(1, 1, 2, 3, 4, 5);

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> LottoNumbers.from(duplicateStrategy))
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
                .isThrownBy(() -> LottoNumbers.from(lessLengthStrategy))
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
                .isThrownBy(() -> LottoNumbers.from(overLengthStrategy))
                .withMessage(LOTTO_TICKET_EXCEPTION_MESSAGE);
    }
}
