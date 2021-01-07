package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoManager {

    private final Lottos lottos;
    private final AnswerLotto answerLotto;

    public LottoManager(Lottos lottos, AnswerLotto answerLotto) {
        this.lottos = lottos;
        this.answerLotto = answerLotto;
    }

    public Map<LottoStatus, Integer> resultOfLottos() {
        Map<LottoStatus, Integer> result = new HashMap<>();

        for (LottoStatus lottoStatus : LottoStatus.getLottoStatuses()) {
            result.put(lottoStatus, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            LottoStatus lottoStatus = answerLotto.getResult(lotto);
            insertIfNotNull(result, lottoStatus);
        }
        return result;
    }

    private void insertIfNotNull(Map<LottoStatus, Integer> result, LottoStatus lottoStatus) {
        if (lottoStatus != null) {
            result.put(lottoStatus, result.get(lottoStatus) + 1);
        }
    }

}
