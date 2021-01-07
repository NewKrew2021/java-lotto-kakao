package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BonusNumberTest {

    @Test
    public void create() {
        BonusNumber bonusNum = new BonusNumber(7);
        assertThat(bonusNum).isEqualTo(new BonusNumber(7));
    }
}
