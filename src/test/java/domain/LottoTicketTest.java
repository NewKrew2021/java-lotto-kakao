package domain;

import domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTicketTest {

    @Test
    @DisplayName("LottoTicket의 객체 생성 테스트")
    public void create() {
        LottoTicket lottoTicket = LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 45));
        assertThat(lottoTicket).isEqualTo(LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 45)));
    }

    @Test
    @DisplayName("로또 티켓 번호의 개수가 6이 아니면 InvalidLottoNumberException을 던진다.")
    public void isInValidLength() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5)));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList()));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(null));
    }

    @Test
    @DisplayName("로또 티켓 번호가 중복되면 InvalidLottoNumberException을 던진다.")
    void isDuplicateNumber() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(1, 1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("로또 티켓 번호가 1보다 미만이거나 45를 초과하면 InvalidLottoNumberException을 던진다.")
    void isInvalidNumber() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(0, 2, 3, 4, 5, 6)));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 46)));
    }
}
