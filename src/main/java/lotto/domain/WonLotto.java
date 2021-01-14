package lotto.domain;

public class WonLotto {
    private final Lotto wonLotto;
    private final LottoNumber bonusNumber;

    public WonLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.wonLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWonLotto() {
        return wonLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
