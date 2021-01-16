package lotto.domain;

public class WonLotto {
    private final Lotto wonLotto;
    private final LottoNumber bonusNumber;

    public WonLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.wonLotto = lotto;
        if (wonLotto.contain(bonusNumber)) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다");
        }
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWonLotto() {
        return wonLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
