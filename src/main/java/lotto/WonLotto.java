package lotto;

public class WonLotto {
    private Lotto wonLotto;
    private int bonusNo;

    private LottoGenerator lottoGenerator = new LottoGenerator();

    public WonLotto(){
        this.wonLotto = lottoGenerator.generateLotto();
        this.bonusNo = lottoGenerator.generateBonus(wonLotto);
    }

    public Lotto getWonLotto(){
        return wonLotto;
    }
    public int getBonusNo(){
        return bonusNo;
    }
}
