import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoResult;
import lotto.Lottos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.Lotto.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoApplicationTest {

    @Test
    void buyManualLottos() {
        Lottos lottos = new Lottos();

        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(11, 12, 13, 14, 15, 16);

        lottos.addLotto(Lotto.generateManualLotto(lottoNumbers1));
        lottos.addLotto(Lotto.generateManualLotto(lottoNumbers2));

        assertEquals(2, lottos.getLottos().size());
    }

    @Test
    void buyRandomLottos() {
        Lottos lottos = new Lottos();

        lottos.addLotto(Lotto.generateRandomLotto());
        lottos.addLotto(Lotto.generateRandomLotto());

        assertEquals(2, lottos.getLottos().size());
    }
    @Test
    void validateMoney() {
        LottoApplication.validateMoney(1000);
        assertThatThrownBy(() -> {
            LottoApplication.validateMoney(200);
        });
        assertThatThrownBy(() -> {
            LottoApplication.validateMoney(10010);
        });
    }

    @Test
    void getEarningRate() {
        Lottos lottos = new Lottos();
        List<LottoResult> lottoResults;
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(11, 12, 13, 14, 15, 16);

        lottos.addLotto(Lotto.generateManualLotto(lottoNumbers1));
        lottos.addLotto(Lotto.generateManualLotto(lottoNumbers2));

        Lotto winningLotto = Lotto.generateManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(7);

        lottoResults = lottos.checkLottos(winningLotto, bonusNumber);

        long totalReward = lottoResults.stream().mapToLong(result -> result.getReward()).sum();
        double earningRate = totalReward / (lottos.getLottos().size() * LOTTO_PRICE);

        assertEquals(1_000_000, earningRate);
    }

    @Test
    void makeStatistics() {
        Lottos lottos = new Lottos();
        List<LottoResult> lottoResults;
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(11, 12, 13, 14, 15, 16);

        lottos.addLotto(Lotto.generateManualLotto(lottoNumbers1));
        lottos.addLotto(Lotto.generateManualLotto(lottoNumbers2));

        Lotto winningLotto = Lotto.generateManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(7);

        lottoResults = lottos.checkLottos(winningLotto, bonusNumber);

        Map<LottoResult, Long> statistics = lottoResults.stream().collect(Collectors.groupingBy(lottoResult -> lottoResult, Collectors.counting()));

        assertEquals(1, statistics.get(LottoResult.FIRST));
    }
}
