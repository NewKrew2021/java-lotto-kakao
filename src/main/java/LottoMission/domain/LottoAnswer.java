package LottoMission.domain;

import java.util.Set;

public class LottoAnswer {

    private final LottoNumbers answerNumbers;
    private final LottoNumber bonusNumber;

    public LottoAnswer(LottoNumbers answerNumbers, LottoNumber bonusNumber) {
        if(answerNumbers.isContainLottoNumber(bonusNumber)){
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 같을 수 없습니다.");
        }
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<LottoNumber> getAnswerNumbers() {
        return answerNumbers.getNumbers();
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
