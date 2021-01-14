package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    @DisplayName("1~45범위 밖에서 에러 발생하는지 확인")
    public void testAmountRange() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> LottoNumber.of(0));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> LottoNumber.of(46));
    }

    @Test
    @DisplayName("서로다른 번호 6개로 로또번호가 생성된것인지 확인")
    public void testLottoSize() {
        Lotto lotto = new Lotto();
        Assertions.assertTrue(lotto.getLottoNumbers().size() == 6);
        HashSet<LottoNumber> set = new HashSet<>();
        set.addAll(lotto.getLottoNumbers());
        Assertions.assertTrue(set.size() == 6);
    }


}
