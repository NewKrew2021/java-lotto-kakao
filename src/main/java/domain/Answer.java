package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Answer {

    private final List<Integer> answerNumbers;
    private final int bonusNumber;

    public Answer(List<Integer> answerNumbers, int bonusNumber) {
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

    public LottoStatus getResult(Lotto lotto) {
        return LottoStatus.findStatus(getMatchingNumber(lotto.getLottoNumbers()), isMatchedBonusNumber(lotto.getLottoNumbers()));
    }

    private boolean isMatchedBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().anyMatch(number -> number == bonusNumber);
    }

    private int getMatchingNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().filter(number -> answerNumbers.contains(number)).collect(Collectors.toList()).size();
    }

}
