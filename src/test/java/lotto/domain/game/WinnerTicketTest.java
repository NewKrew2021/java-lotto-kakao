package lotto.domain.game;

import lotto.domain.OneToSixGenerator;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTicketTest {

    @DisplayName("당첨 로또 번호와 보너스 넘버가 주어지면 당첨 티켓을 생성한다.")
    @Test
    void create() {
        //given
        LottoNumbers winnerNumbers = LottoNumbers.from(new OneToSixGenerator());
        LottoNumber bonusNumber = LottoNumber.valueOf(7);

        //when
        WinnerTicket winnerTicket = new WinnerTicket(winnerNumbers, bonusNumber);

        //then
        List<LottoNumber> expected = Arrays.asList(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)
        );
        assertThat(winnerTicket.getWinnerNumbers().getLottoNumbers()).isEqualTo(expected);
        assertThat(winnerTicket.getBonusNumber()).isEqualTo(LottoNumber.valueOf(7));
    }

    @DisplayName("당첨 티켓과 로또 티켓이 주어지면, 일치하는 개수를 구한다.")
    @ParameterizedTest
    @MethodSource("generateLottoTicket")
    void matchNumbers(LottoNumbers lottoTicket, int expected) {
        //given
        WinnerTicket winnerTicket = new WinnerTicket(LottoNumbers.from(new OneToSixGenerator()), LottoNumber.valueOf(7));

        //when
        int matchNumber = winnerTicket.countMatchingNumber(lottoTicket);

        //then
        assertThat(matchNumber).isEqualTo(expected);
    }

    private static Stream<Arguments> generateLottoTicket() {
        return Stream.of(
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(1, 2, 7, 4, 5, 6)), 5),
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(1, 2, 7, 8, 5, 6)), 4),
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(1, 4, 3, 8, 9, 10)), 3),
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(10, 45, 44, 43, 2, 3)), 2),
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(31, 42, 13, 24, 15, 5)), 1),
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(11, 22, 33, 44, 35, 36)), 0)
        );
    }

    @DisplayName("당첨 티켓과 로또 티켓이 주어지면, 보너스 여부를 확인한다.")
    @ParameterizedTest
    @MethodSource("generateLottoTicket2")
    void hasBonus(LottoNumbers lottoTicket, int bonusNumber, boolean expected) {
        //given
        WinnerTicket winnerTicket = new WinnerTicket(
                LottoNumbers.from(new OneToSixGenerator()),
                LottoNumber.valueOf(bonusNumber)
        );

        //when
        boolean hasBonusNumber = winnerTicket.hasBonus(lottoTicket);

        //then
        assertThat(hasBonusNumber).isEqualTo(expected);
    }

    private static Stream<Arguments> generateLottoTicket2() {
        return Stream.of(
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(1, 2, 3, 4, 5, 6)), 4, true),
                Arguments.of(LottoNumbers.from(() -> Arrays.asList(1, 2, 7, 4, 5, 6)), 10, false)
        );
    }

}
