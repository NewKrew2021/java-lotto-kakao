package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WonLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WonLottoTest {


    private WonLotto wonLotto;

    @BeforeEach
    void setUp() {
        wonLotto = new WonLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    @DisplayName("서로다른 번호 7개로 당첨번호가 생성된것인지 확인")
    void testWonLottoSize() {

        HashSet<Integer> set = new HashSet<>();
        set.addAll(wonLotto.getWonLotto().getLotto());
        Assertions.assertTrue(set.size() == 6);

        set.add(wonLotto.getBonusNo());
        Assertions.assertTrue(set.size() == 7);

    }

    @Test
    @DisplayName("일치하는 번호에 따른 등수 확인")
    void testCheckRanking() {
        LottoRank rank = wonLotto.checkRanking(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(rank).isEqualTo(LottoRank.FIRST);

        rank = wonLotto.checkRanking(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }
}
