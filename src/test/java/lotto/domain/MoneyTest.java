package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    void testInputMoney(){
        Money money = Money.of(1000);
        assertThat(money.getPossibleLottoCount()).isEqualTo(1);

        assertThatThrownBy(()->{
            Money money2 = Money.of(500);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void testBuyingLotto(){
        Money money = Money.of(5000);
        money.buyLottos(3);

        assertThat(money.getPossibleLottoCount()).isEqualTo(2);
        assertThatThrownBy(() -> {
            money.buyLottos(5);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
