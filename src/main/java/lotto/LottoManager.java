package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.Lotto.LOTTO_PRICE;

public class LottoManager {

    private Lottos lottos = new Lottos();
    private List<LottoResult> lottoResults;

    public void buyRandomLottos(int money) {
        validateMoney(money);
        int numberOfLottos = money / LOTTO_PRICE;
        lottos.addRandomLottos(numberOfLottos);
    }

    public void buyManualLotto(Lotto lotto) {
        lottos.addLotto(lotto);
    }

    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money == 0) {
            throw new IllegalArgumentException();
        }
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getNumberOfLottos() {
        return lottos.getLottos().size();
    }

    public void checkLottos(Lotto winningLotto, LottoNumber bonusNumber) {
        lottoResults = lottos.checkLottos(winningLotto, bonusNumber);
    }

    public Map<LottoResult, Integer> makeStatistics() {
        Map<LottoResult, Integer> statistics = new HashMap<>();

        for(LottoResult lottoResult : LottoResult.values()){
            statistics.put(lottoResult, 0);
        }

        for(LottoResult lottoResult : lottoResults){
            statistics.put(lottoResult, statistics.get(lottoResult) + 1);
        }

        return statistics;
    }

    public long getEarningRate() {
        return getTotalReward() * 100 / (getNumberOfLottos() * LOTTO_PRICE);
    }

    private long getTotalReward() {
        return lottoResults.stream().mapToInt(result -> result.getReward()).sum();
    }

}
