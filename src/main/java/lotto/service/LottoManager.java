package lotto.service;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoManager {

    private Lottos lottos;
    private WonLotto wonLotto;


    private final LottoGenerator lottoGenerator=LottoGenerator.getInstance();

    public void runLottoManager(){

        buyLotto();

        Lotto lotto=lottoGenerator.lottoStringParser(LottoInputView.getWonLotto());
        int bonusBall=LottoInputView.getBonusBall();

        WonLotto wonLotto=new WonLotto(lotto,bonusBall);

        LottoReview review = new LottoReview(lottos, wonLotto);

        LottoOutputView.printWonResultPhrase();
        LottoOutputView.printSameCountPhrase(review.getSameCountList());
        LottoOutputView.printProfitRatio(review.getProfitRatio());
    }


    public void buyLotto(){

        int money = LottoInputView.getLottoBuyAmount();

        int nonAutoMoney = buyNonAutoLotto(money);

        int buyCount=amount/LOTTO_PRICE;
        LottoOutputView.printInputQuantityPhrase(buyCount);
        Lottos lottos=new Lottos();
        for(int i=0;i<amount/1000;i++){
            lottos.add(lottoGenerator.generateLotto());
        }

        LottoOutputView.printLottos(lottos);
    }

    public int buyNonAutoLotto(){

    }
}
