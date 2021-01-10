package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("LottoTickets 객체 생성 테스트")
    public void create(){
        Lotto ticket1 = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        Lotto ticket2 = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,7));
        Lotto ticket3 = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,8));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3));
        assertThat(tickets.size()).isEqualTo(3);
    }

}
