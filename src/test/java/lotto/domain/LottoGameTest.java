package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    @Test
    public void create() {
        LottoGame game = new LottoGame(14000);
        assertThat(game).isEqualTo(new LottoGame(14000));
    }
}
