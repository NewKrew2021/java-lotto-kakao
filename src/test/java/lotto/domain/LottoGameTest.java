package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    @Test
    public void When_TwoLottoGameInitializedWithSameMoney_Expected_isEqualToTrue() {
        LottoGame game = new LottoGame(new Money(14000));
        assertThat(game).isEqualTo(new LottoGame(new Money(14000)));
    }

}