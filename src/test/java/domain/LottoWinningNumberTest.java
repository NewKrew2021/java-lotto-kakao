package domain;

import domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoWinningNumberTest {

    @Test
    @DisplayName("LottoWinningNumber의 객체 생성 테스트")
    void create() {
        LottoTicket lottoWinningTicket = LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);
        assertThat(lottoWinningNumber).isEqualTo(new LottoWinningNumber(lottoWinningTicket, bonusNumber));
    }

    @Test
    @DisplayName("보너스번호의 숫자가 티켓의 번호와 중복되면 InvalidLottoNumberException을 던진다.")
    void isDuplicate() {
        LottoTicket lottoWinningTicket = LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new LottoWinningNumber(lottoWinningTicket, bonusNumber));
    }

}