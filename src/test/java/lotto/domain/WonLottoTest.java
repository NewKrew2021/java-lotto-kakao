package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class WonLottoTest {
    private WonLotto wonLotto;

    @BeforeEach
    void setUp() {
        wonLotto = new WonLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.of(7));
    }

    @Test
    @DisplayName("서로다른 번호 7개로 당첨번호가 생성된것인지 확인")
    void testWonLottoSize() {
        HashSet<LottoNumber> set = new HashSet<>();
        set.addAll(wonLotto.getWonLotto().getLottoNumbers());
        Assertions.assertTrue(set.size() == 6);
        set.add(wonLotto.getBonusNumber());
        Assertions.assertTrue(set.size() == 7);
    }

}
