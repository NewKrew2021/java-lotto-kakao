package domain;

import domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTicketTest {

    @Test
    public void create() {
        LottoTicket lottoTicket = LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 45));
        assertThat(lottoTicket).isEqualTo(LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 45)));
    }

    @Test
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
    void isDuplicateNumber() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(1, 1, 2, 3, 4, 5)));
    }

    @Test
    void isInvalidNumber() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(0, 2, 3, 4, 5, 6)));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> LottoTicket.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 46)));
    }
}
