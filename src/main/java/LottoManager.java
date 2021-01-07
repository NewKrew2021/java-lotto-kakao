import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final Lottos lottos;
    private final AnswerLotto answerLotto;

    public LottoManager(Lottos lottos, AnswerLotto answerLotto) {
        this.lottos = lottos;
        this.answerLotto = answerLotto;
    }

    public Map<LottoStatus, Integer> checkResult() {
        Map<LottoStatus, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            LottoStatus lottoStatus = answerLotto.getResult(lotto);
            result.put(lottoStatus, getRankCount(result, lottoStatus));
        }
        return result;
    }

    private int getRankCount(Map<LottoStatus, Integer> result, LottoStatus lottoStatus) {
        if (!result.containsKey(lottoStatus)) {
            return 1;
        }
        return result.get(lottoStatus) + 1;
    }

}
