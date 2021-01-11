package domain;

import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class LottosTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    public void createLottos() {
        winningLotto = new WinningLotto(Arrays.asList(1, 7, 8, 9, 10, 11),34);
        lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13))
                )
        );
    }
}
