package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WonLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    Lottos lottos = new Lottos();

    @BeforeEach
    void setUp(){
        lottos.add(LottoGenerator.getInstance().generateLotto());
    }

    @Test
    void testAddToLottos(){
        assertThat(lottos.getLottos().size()).isEqualTo(1);
    }

    @Test
    void testUnableToAdd(){
        lottos.getLottos().clear();
        assertThat(lottos.getLottos().size()).isNotEqualTo(0);
    }

}
