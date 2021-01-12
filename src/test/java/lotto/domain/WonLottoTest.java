package lotto.domain;

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

    private LottoGenerator generator;
    private WonLotto wonLotto;
    Lotto lotto;
    int bonusNo;

    @BeforeEach
    void setUp(){
        generator = LottoGenerator.getInstance();
        lotto = generator.generateLotto();
        bonusNo = generator.generateBonus(lotto);
        wonLotto = new WonLotto(lotto, bonusNo);
    }

    @Test
    @DisplayName("서로다른 번호 7개로 당첨번호가 생성된것인지 확인")
    void testWonLottoSize(){

        HashSet<Integer> set = new HashSet<>();
        wonLotto.getWonLotto().getLotto().stream().forEach(number -> set.add(number.getNumber()));
        Assertions.assertTrue(set.size()==6);

        set.add(wonLotto.getBonusNo());
        Assertions.assertTrue(set.size()==7);

    }

    @Test
    @DisplayName("일치하는 번호에 따른 등수 확인")
    void testCheckRanking() {
        LottoRank rank = wonLotto.checkRanking(lotto);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }
}
