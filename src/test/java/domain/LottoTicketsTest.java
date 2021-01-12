package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    private static Lotto ticket1;
    private static Lotto ticket2;

    @BeforeEach
    public void setUp(){
        ticket1 = Lotto.from(new LottoManualGenerator(Arrays.asList(1,2,3,4,5,6)));
        ticket2 = Lotto.from(new LottoManualGenerator(Arrays.asList(1,2,3,4,5,7)));
    }

    @Test
    @DisplayName("LottoTickets 객체 생성 테스트")
    public void create(){
        Lotto ticket3 = Lotto.from(new LottoManualGenerator(Arrays.asList(1,2,3,4,5,8)));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3));
        assertThat(tickets).isEqualTo(new LottoTickets(Arrays.asList(ticket1,ticket2,ticket3)));
    }

    @Test
    @DisplayName("LottoTickets concat 테스트")
    public void testConCat(){
        LottoTickets tickets1 = new LottoTickets(Arrays.asList(ticket1));
        LottoTickets tickets2 = new LottoTickets(Arrays.asList(ticket2));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket1, ticket2));
        assertThat(tickets1.concat(tickets2)).isEqualTo(tickets);
    }

}
