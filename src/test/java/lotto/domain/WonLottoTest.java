package lotto.domain;

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
        wonLotto = new WonLotto(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), new LottoNumber(7));
    }

    @Test
    @DisplayName("서로다른 번호 7개로 당첨번호가 생성된것인지 확인")
    void testWonLottoSize() {
        HashSet<LottoNumber> set = new HashSet<>();
        set.addAll(wonLotto.getWonLotto().getLottoNumbers());
        Assertions.assertTrue(set.size() == 6);
        set.add(wonLotto.getBonusNo());
        Assertions.assertTrue(set.size() == 7);
    }

    @Test
    @DisplayName("일치하는 번호에 따른 등수 확인")
    void testCheckRanking() {
        LottoRank rank = LottoRank.checkRanking(6,0);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
        rank = LottoRank.checkRanking(5,1);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }
}
