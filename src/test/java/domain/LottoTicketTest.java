package domain;

import domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTicketTest {

    @Test
    public void create(){
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    public void isInValidLength(){
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new LottoTicket(Arrays.asList(1,2,3,4,5)));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new LottoTicket(Arrays.asList(1,2,3,4,5,6,7)));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new LottoTicket(Arrays.asList()));
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new LottoTicket(null));
    }
}
