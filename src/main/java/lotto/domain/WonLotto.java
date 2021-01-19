package lotto.domain;

public class WonLotto {

    private Lotto wonLotto;
    private int bonusNo;

    public WonLotto(Lotto lotto, int bonusNo){
        this.wonLotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Lotto getWonLotto(){
        return wonLotto;
    }

    public int getBonusNo(){
        return bonusNo;
    }

    public LottoRank checkRanking(Lotto lotto){
        int matchNo=wonLotto.checkSameCount(lotto);

        boolean isBonusMatched=lotto.getLotto().contains(LottoNumber.makeNumber(bonusNo));

        return LottoRank.rankForMatched(matchNo, isBonusMatched);
    }
}
