package mission.lotto.domain;

import java.util.Set;

public class LottoAnswer {

    private final Lotto answerNumbers;
    private final Number bonusNumber;

    public LottoAnswer(Lotto answerNumbers, Number bonusNumber) {
        if (answerNumbers.isContainLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 같을 수 없습니다.");
        }
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<Number> getAnswerNumbers() {
        return answerNumbers.getNumbers();
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

}
