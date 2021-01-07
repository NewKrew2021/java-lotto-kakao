package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BonusNumberTest {

    @Test
    public void create() {
        BonusNumber bonusNum = new BonusNumber(7);
        assertThat(bonusNum).isEqualTo(new BonusNumber(7));
    }

    @Test
    public void same() {
        BonusNumber bonusNum = new BonusNumber(7);
        assertThat(bonusNum.isSame(new LottoNumber(7))).isTrue();
    }

    @Test
    public void unsame() {
        BonusNumber bonusNum = new BonusNumber(10);
        assertThat(bonusNum.isSame(new LottoNumber(7))).isFalse();
    }
}
