package lotto;

import org.junit.jupiter.api.BeforeEach;

public class LottoTest {
    private Lotto lotto;
    @BeforeEach
    void setUp(){
        lotto = new Lotto();
    }

}
//raffleForOne -> 사용자의 공 하나 -> 당첨, 보너스볼, 아무것도 아닌지
//raffleForAll -> raffleForOne을 6번