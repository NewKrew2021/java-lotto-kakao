package lotto.service;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoManager {

    private Money money;
    private Lottos lottos;
    private WonLotto wonLotto;
    private LottoReview review;

    private final LottoGenerator lottoGenerator=LottoGenerator.getInstance();

    public LottoManager(){
        lottos=new Lottos();
    }

    public void runLottoManager(){
        insertMoney();

        buyLotto(money);

        makeWonLotto();

        makeReview();

        printLottoResult();
    }

    private void insertMoney(){
        int moneyInput = LottoInputView.getLottoBuyAmount();
        money = Money.makeMoney(moneyInput);
    }

    private void buyLotto(Money money){
        int originCount = money.getPossibleLottoCount();
        buyNonAutoLotto(money);

        int autoBuyCount=money.getPossibleLottoCount();
        int nonAutoBuyCount = originCount - autoBuyCount;

        LottoOutputView.printInputQuantityPhrase(nonAutoBuyCount, autoBuyCount);

        for(int i=0;i<autoBuyCount;i++){
            lottos.add(lottoGenerator.generateLotto());
        }

        LottoOutputView.printLottos(lottos);
    }

    private void buyNonAutoLotto(Money money){
        int amount = LottoInputView.getNonAutoLottoBuyAmount();

        if(amount == 0)
            return ;

        LottoOutputView.printInputNonAutoLottoPhrase();
        for (int i = 0; i < amount; i++) {
            lottos.add(lottoGenerator.lottoStringParser(LottoInputView.getNonAutoLotto()));
        }
        money.buyLottos(amount);
    }

    private void makeWonLotto(){
        Lotto lotto=lottoGenerator.lottoStringParser(LottoInputView.getWonLotto());
        int bonusBall=LottoInputView.getBonusBall();

        wonLotto = new WonLotto(lotto,bonusBall);
    }

    private void makeReview(){
        review = new LottoReview(lottos, wonLotto);
    }

    private void printLottoResult(){
        LottoOutputView.printWonResultPhrase();
        LottoOutputView.printSameCountPhrase(review.getSameCountList());
        LottoOutputView.printProfitRatio(review.getProfitRatio());
    }

    public LottoReview getReview(){
        final LottoReview review = new LottoReview(lottos, wonLotto);
        return review;
    }
}
