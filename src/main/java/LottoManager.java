import java.util.List;

public class LottoManager {

    public LottoStatus checkResult(Lotto lotto, AnswerLotto answerLotto) {
        return answerLotto.getResult(lotto);
    }

}
