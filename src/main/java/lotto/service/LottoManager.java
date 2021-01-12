package lotto.service;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoManager {

    LottoGenerator lottoGenerator=LottoGenerator.getInstance();

    public void runLottoManager(){

        Lottos lottos= buyLotto();
        LottoOutputView.printLottos(lottos);

        Lotto lotto=lottoGenerator.lottoStringParser(LottoInputView.getWonLotto());
        int bonusBall=LottoInputView.getBonusBall();

        WonLotto wonLotto=new WonLotto(lotto,bonusBall);

        LottoReview review = new LottoReview(lottos, wonLotto);

        LottoOutputView.printWonResultPhrase();
        LottoOutputView.printSameCountPhrase(review.getSameCountList());
        LottoOutputView.printProfitRatio(review.getProfitRatio());
    }


    public Lottos buyLotto(){

        int amount=LottoInputView.getLottoBuyAmount();
        int buyCount=amount/1000;
        LottoOutputView.printInputQuantityPhrase(buyCount);
        Lottos lottos=new Lottos();
        for(int i=0;i<amount/1000;i++){
            lottos.add(lottoGenerator.generateLotto());
        }
        return lottos;
    }

}
