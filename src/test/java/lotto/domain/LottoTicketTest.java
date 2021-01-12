package lotto.domain;

import lotto.exception.IllegalTicketStateException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    public void testCreate() {
        LottoTicket lottoTicket = new LottoTicket(10);
        assertThat(lottoTicket).isEqualTo(new LottoTicket(10));
    }

    @Test
    public void testIllegalCreate() {
        assertThatThrownBy(() -> {
            new LottoTicket(-1);
        }).isInstanceOf(IllegalTicketStateException.class);
    }

    @Test
    public void when_useTicket_Expect_ticketDecreaseByOne() {
        LottoTicket lottoTicket = new LottoTicket(10);
        lottoTicket.useTicket();
        assertThat(lottoTicket).isEqualTo(new LottoTicket(9));
    }

    @Test
    public void isRemain_remainIs0_False() {
        LottoTicket lottoTicket = new LottoTicket(1);
        lottoTicket.useTicket();
        assertThat(lottoTicket.isRemain()).isFalse();
    }

    @Test
    public void isRemain_remainIs1_True() {
        LottoTicket lottoTicket = new LottoTicket(2);
        assertThat(lottoTicket.isRemain()).isTrue();
    }
}
