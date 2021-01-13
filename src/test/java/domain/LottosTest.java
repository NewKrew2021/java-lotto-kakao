package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    public void createLottos() {
        winningLotto = new WinningLotto(LottoTest.getLottoBalls(1,7,8,9,10,11),34);
        lottos = new Lottos(
                Arrays.asList(
                        new Lotto(LottoTest.getLottoBalls(1,7,8,9,10,11)),
                        new Lotto(LottoTest.getLottoBalls(1,7,8,9,10,11)),
                        new Lotto(LottoTest.getLottoBalls(1,7,8,9,10,11)),
                        new Lotto(LottoTest.getLottoBalls(1,7,8,9,10,13)),
                        new Lotto(LottoTest.getLottoBalls(1,7,8,9,10,13)),
                        new Lotto(LottoTest.getLottoBalls(1,7,8,9,10,13))
                )
        );
    }

    @Test
    void getRankCounts(){
        HashMap<LottoRank, Integer> rankCounts = lottos.getRankCounts(winningLotto);
        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(3);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(3);
    }
}
