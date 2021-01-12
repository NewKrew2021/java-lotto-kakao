package lotto.domain;

import lotto.exception.IllegalTicketsStateException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {

    @Test
    public void testCreate() {
        LottoTickets lottoTickets = new LottoTickets(new Money(14000), 1);
        assertThat(lottoTickets).isEqualTo(new LottoTickets(new Money(14000), 1));
    }

    @Test
    void testIllegalCreate() {
        assertThatThrownBy(() -> {
            new LottoTickets(new Money(1000), 2);
        }).isInstanceOf(IllegalTicketsStateException.class);
    }

}
