package lotto.domain;

public class WonLotto {
    private final Lotto wonLotto;
    private final LottoNumber bonusNo;

    public WonLotto(Lotto lotto, LottoNumber bonusNo) {
        this.wonLotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Lotto getWonLotto() {
        return wonLotto;
    }

    public LottoNumber getBonusNo() {
        return bonusNo;
    }

}
