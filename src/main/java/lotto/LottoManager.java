package lotto;

public class LottoManager {

    LottoInputView lottoInputView=new LottoInputView();
    LottoOutputView lottoOutputView=new LottoOutputView();
    LottoGenerator lottoGenerator=new LottoGenerator();

    public void runLottoManager(){

        Lottos lottos= buyLotto();
        lottoOutputView.printLottos(lottos);
        lottoOutputView.printInputWonlottoPhrase();
        Lotto lotto=lottoGenerator.lottoStringParser(lottoInputView.getWonLotto());
        lottoOutputView.printInputBonusBallPhrase();
        int bonusBall=lottoInputView.getBonusBall();
        WonLotto wonLotto=new WonLotto(lotto,bonusBall);
        lottoOutputView.printInputWonlottoPhrase();

        lottoOutputView.printSameCountPhrase(lottos.lottosRankingResult(lottos.lottosResult(wonLotto)));
        lottoOutputView.printProfitRatio(new LottoReview().getProfitRatio(lottos.lottosResult(wonLotto)));

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
