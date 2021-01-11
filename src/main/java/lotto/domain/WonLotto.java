package lotto.domain;

public class WonLotto {

    private Lotto wonLotto;
    private int bonusNo;

    private LottoGenerator lottoGenerator = LottoGenerator.getInstance();

    public WonLotto(){
        this.wonLotto = lottoGenerator.generateLotto();
        this.bonusNo = lottoGenerator.generateBonus(wonLotto);
    }

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

        boolean isBonusMatched=lotto.getLotto().contains(bonusNo);

        return LottoRank.rankForMatched(matchNo, isBonusMatched);
    }
}
