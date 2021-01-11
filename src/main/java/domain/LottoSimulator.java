package domain;

import java.util.Map;

public class LottoSimulator {

    private Lottos lottos;
    private Answer answer;

    public LottoSimulator(Lottos lottos, Answer answer) {
        this.lottos = lottos;
        this.answer = answer;
    }

    public long getWinningMoney() {
        Map<LottoStatus, Integer> lottoResult = lottos.checkResult(answer);
        return lottoResult.entrySet().stream()
                .map(e -> e.getValue() * e.getKey().getWinnings())
                .reduce(Long::sum)
                .get();
    }

    public Map<LottoStatus, Integer> getLottoResults() {
        return lottos.checkResult(answer);
    }

    public double getProfit() {
        long purchaseMoney = lottos.getTotalPurchaseCount() * PurchaseInfos.LOTTO_PRICE;
        return (double) (getWinningMoney() - purchaseMoney) / (double) purchaseMoney;
    }

}
