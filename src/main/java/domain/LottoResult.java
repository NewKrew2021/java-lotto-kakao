package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

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

    public int getWinningMoney() {
        return lottoResult.entrySet().stream()
                .map(e -> e.getValue() * e.getKey().getWinngs())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public Map<LottoStatus, Integer> getLottoResult() {
        return lottoResult;
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

