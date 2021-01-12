package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {
    @Test
    void 범위() {
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new Money(900))
                .withMessageContaining("금액이 부족합니다.");
    }

    @Test
    void 로또_개수() {
        Money money = new Money(3000);

        assertThat(money.getLottoCount())
                .isEqualTo(3);
    }
}

