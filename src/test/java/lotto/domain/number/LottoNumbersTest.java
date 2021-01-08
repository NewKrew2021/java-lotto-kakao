package lotto.domain.number;

import lotto.domain.OneToSixGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.number.LottoNumbers.LOTTO_TICKET_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @DisplayName("숫자를 생성하는 전략이 주어 졌을 때 로또 티켓을 생성한다.")
    @Test
    void create() {
        //given
        NumberGenerateStrategy strategy = new OneToSixGenerator();

        //when
        LottoNumbers lottoNumbers = LottoNumbers.from(strategy);

        //then
        List<LottoNumber> expected = Arrays.asList(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6));
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

    @DisplayName("2개의 로또 넘버 일급 컬렉션이 주어지면 일치하는 숫자의 갯수를 구한다.")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    void countMatchingNumber(List<Integer> compared, int expected) {
        //given
        LottoNumbers lottoNumbers = LottoNumbers.from(new OneToSixGenerator());
        LottoNumbers comparedNumbers = LottoNumbers.from(() -> compared);

        //when
        int result = lottoNumbers.countMatchingNumber(comparedNumbers);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 6), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 6), 4),
                Arguments.of(Arrays.asList(3, 4, 1, 8, 7, 9), 3),
                Arguments.of(Arrays.asList(14, 22, 10, 6, 4, 9), 2),
                Arguments.of(Arrays.asList(14, 42, 33, 41, 6, 22), 1),
                Arguments.of(Arrays.asList(21, 32, 23, 34, 45, 16), 0)
        );
    }

    @DisplayName("로또 넘버 일급 컬렉션과 로또 번호가 주어지면 일급 컬렉션의 로또 번호 포함 여부를 구한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "6,true", "7,false"})
    void contains(int given, boolean expected) {
        //given
        LottoNumbers lottoNumbers = LottoNumbers.from(new OneToSixGenerator());
        LottoNumber lottoNumber = LottoNumber.valueOf(given);

        //when
        boolean result = lottoNumbers.contains(lottoNumber);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
