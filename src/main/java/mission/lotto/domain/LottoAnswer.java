package mission.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoAnswer {

    private final Lotto answerNumbers;
    private final Number bonusNumber;

    public LottoAnswer(List<Integer> sixNumberList, int bonus) {
        Lotto lotto = new Lotto(sixNumberList);
        Number bonusNumber = Number.of(bonus);
        if (lotto.isContainLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 같을 수 없습니다.");
        }
        this.answerNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Set<Number> getAnswerNumbers() {
        return Collections.unmodifiableSet(answerNumbers.getNumbers());
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

}
