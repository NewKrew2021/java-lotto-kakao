package lotto.domain;

import java.util.Objects;

public class LottoGame {

    private final int money;

    public LottoGame(int money) {
        this.money = money;
    }

    public int buyLotto() {
        return this.money / 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return money == lottoGame.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
