package lotto.service;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoManager {

    LottoInputView lottoInputView=new LottoInputView();
    LottoOutputView lottoOutputView=new LottoOutputView();
    LottoGenerator lottoGenerator=LottoGenerator.getInstance();

    public void runLottoManager(){

        Lottos lottos= buyLotto();
        lottoOutputView.printLottos(lottos);
        lottoOutputView.printInputWonlottoPhrase();
        Lotto lotto=lottoGenerator.lottoStringParser(lottoInputView.getWonLotto());
        lottoOutputView.printInputBonusBallPhrase();
        int bonusBall=lottoInputView.getBonusBall();
        WonLotto wonLotto=new WonLotto(lotto,bonusBall);

        LottoReview review = new LottoReview(lottos, wonLotto);

        //lottoOutputView.printSameCountPhrase(lottos.lottosRankingResult(lottos.lottosResult(wonLotto)));
        //lottoOutputView.printProfitRatio(new LottoReview().getProfitRatio(lottos.lottosResult(wonLotto)));
        lottoOutputView.printSameCountPhrase(review.getSameCountList());
        lottoOutputView.printProfitRatio(review.getProfitRatio());
    }


    public Lottos buyLotto(){

        lottoOutputView.printInputMoneyPhrase();
        int amount=lottoInputView.getLottoBuyAmount();
        int buyCount=amount/1000;
        lottoOutputView.printInputQuantityPhrase(buyCount);
        Lottos lottos=new Lottos();
        for(int i=0;i<amount/1000;i++){
            lottos.add(lottoGenerator.generateLotto());
        }
        return lottos;
    }

}
