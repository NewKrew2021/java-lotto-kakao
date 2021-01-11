package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    @Test
    public void create() {
        LottoGame game = new LottoGame(new Money(14000));
        assertThat(game).isEqualTo(new LottoGame(new Money(14000)));
    }

    @Test
    public void buyLottoOne() {
        LottoGame game = new LottoGame(new Money(1500));
        List<List<String>> expected = game.buyLotto(()-> new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        assertThat(expected).containsOnly(Arrays.asList("1", "2", "3", "4", "5", "6"));
    }
}