package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.Lotto.LOTTO_PRICE;

public class LottoManager {

    private Lottos lottos = new Lottos();
    private List<LottoResult> lottoResults;

    public void buyRandomLotto() {
        lottos.addRandomLotto();
    }

    public void buyManualLotto(List<Integer> numbers) {
        lottos.addManualLotto(Lotto.generateManualLotto(numbers));
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getNumberOfLottos() {
        return lottos.getLottos().size();
    }

    public void checkLottos(List<Integer> winningLotto, int bonusNumber) {
        lottoResults = lottos.checkLottos(Lotto.generateManualLotto(winningLotto), LottoNumber.of(bonusNumber));
    }

    public Map<LottoResult, Long> makeStatistics() {
        return lottoResults.stream().collect(Collectors.groupingBy(lottoResult -> lottoResult, Collectors.counting()));
    }

    public double getEarningRate() {
        return getTotalReward() / (getNumberOfLottos() * LOTTO_PRICE);
    }

    private long getTotalReward() {
        return lottoResults.stream().mapToLong(result -> result.getReward()).sum();
    }

}
