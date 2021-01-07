package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnswerLotto {

    private final List<Integer> answerLotto;
    private final int bonusNumber;

    public AnswerLotto(List<Integer> answerLotto, int bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoStatus getResult(Lotto lotto) {
        return LottoStatus.findStatus(getMatchingNumber(lotto.getLotto()),isMatchedBonusNumber(lotto.getLotto()));
    }

    private boolean isMatchedBonusNumber(List<Integer> lotto) {
        return lotto.stream().anyMatch(number -> number == bonusNumber);
    }

    private int getMatchingNumber(List<Integer> lotto) {
        return lotto.stream().filter(number -> answerLotto.contains(number)).collect(Collectors.toList()).size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerLotto that = (AnswerLotto) o;
        return bonusNumber == that.bonusNumber &&
                Objects.equals(answerLotto, that.answerLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerLotto, bonusNumber);
    }
}
