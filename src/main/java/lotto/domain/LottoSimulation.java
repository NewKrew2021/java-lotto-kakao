package lotto.domain;

public class LottoSimulation {
    private final Price price;
    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private LottoResults lottoResults;

    public LottoSimulation(Price price, WinningLotto winningLotto, Lottos lottos) {
        this.price = price;
        this.winningLotto = winningLotto;
        this.lottos = lottos;
    }

    public void confirm() {
        lottoResults = lottos.allCompare(winningLotto);
    }

    public double getYield() {
        return (double) lottoResults.getReward() / price.getPrice();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
