package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoManager {

    private final Lottos lottos;
    private final Answer answer;

    public LottoManager(Lottos lottos, Answer answer) {
        this.lottos = lottos;
        this.answer = answer;
    }

    public Map<LottoStatus, Integer> checkResult() {
        Map<LottoStatus, Integer> result = new HashMap<>();

        for (LottoStatus lottoStatus : LottoStatus.getLottoStatuses()) {
            result.put(lottoStatus, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            LottoStatus lottoStatus = answer.getResult(lotto);
            if (lottoStatus != null) {
                result.put(lottoStatus, result.get(lottoStatus) + 1);
            }
        }
        return result;
    }

}
