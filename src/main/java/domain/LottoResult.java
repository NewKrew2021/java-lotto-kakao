package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private static final long PERCENTAGE = 100;
    private final Map<LottoStatus, Integer> lottoResult;

    public LottoResult(AnswerLotto answerLotto, Lottos lottos) {
        this.lottoResult = makeLottoResult(answerLotto, lottos);
    }

    private Map<LottoStatus, Integer> makeLottoResult(AnswerLotto answerLotto, Lottos lottos) {
        Map<LottoStatus, Integer> result = new HashMap<>();

        for (LottoStatus lottoStatus : LottoStatus.values()) {
            result.put(lottoStatus, 0);
        }

        for (Lotto lotto : lottos.getLottos()) {
            LottoStatus lottoStatus = answerLotto.getResult(lotto);
            result.put(lottoStatus, result.get(lottoStatus) + 1);
        }
        return result;
    }

    public int get(LottoStatus lottoStatus) {
        return lottoResult.get(lottoStatus);
    }

    public long getWinningMoney() {
        return lottoResult.entrySet().stream()
                .map(e -> e.getValue() * e.getKey().getWinnings())
                .reduce(Long::sum)
                .orElse(0L);
    }

    public long profitPercentage(Money money) {
        return getWinningMoney() * PERCENTAGE / money.getMoney();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult);
    }
}

