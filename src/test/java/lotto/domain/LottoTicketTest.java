package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    void lottoNosLengthValidTest() {
        assertThatThrownBy(()->
                new LottoTicket(Arrays.asList( 1,2,3,4,5,6,7 ))
        ).isInstanceOf(IllegalArgumentException.class);

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList( 1,2,3,4,5,6 ));
    }

    @Test
    void duplicateValidTest(){
        assertThatThrownBy(()->
                new LottoTicket(Arrays.asList( 1,2,3,3,5,5 ))
        ).isInstanceOf(IllegalArgumentException.class);

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList( 1,2,3,4,5,6 ));
    }
}
