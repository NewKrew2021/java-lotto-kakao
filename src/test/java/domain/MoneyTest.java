package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 400, 500, 600, 700, 800, 900})
    void 범위(int money) {
        assertThatExceptionOfType(InvalidMoneyException.class)
                .isThrownBy(() -> new Money(money))
                .withMessageContaining("금액이 부족합니다.");
    }

    @Test
    void 로또_개수() {
        Money money = new Money(3000);

        assertThat(money.getAutoLottoCount(0))
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 수동_구매(int count) {
        Money money = new Money(3000);

        assertThatExceptionOfType(InvalidMoneyException.class)
                .isThrownBy(() -> money.checkCanBuy(count))
                .withMessageContaining("금액이 부족합니다.");
    }
}

