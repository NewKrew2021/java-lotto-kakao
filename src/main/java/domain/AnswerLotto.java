package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnswerLotto {
    private static final int BASE_LOTTO_LENGTH = 6;
    private final List<Integer> answerLotto;
    private final int bonusNumber;

    public AnswerLotto(List<Integer> answerLotto, int bonusNumber) {
        checkLottoLength(answerLotto);
        checkLottoHasBonus(answerLotto, bonusNumber);
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoStatus getResult(Lotto lotto) {
        return LottoStatus.findStatus(getMatchingNumber(lotto.getLotto()), isMatchedBonusNumber(lotto.getLotto()));
    }

    private boolean isMatchedBonusNumber(List<Integer> lotto) {
        return lotto.stream().anyMatch(number -> number == bonusNumber);
    }

    private int getMatchingNumber(List<Integer> lotto) {
        return lotto.stream().filter(number -> answerLotto.contains(number)).collect(Collectors.toList()).size();
    }

    List<Integer> getAnswerLotto() {
        return answerLotto;
    }

    private void checkLottoLength(List<Integer> answerLotto) {
        if (answerLotto.size() != BASE_LOTTO_LENGTH) {
            throw new IllegalStateException("로또 길이가 6이 아닙니다.");
        }
    }

    private void checkLottoHasBonus(List<Integer> answerLotto, int bonus) {
        if (answerLotto.contains(bonus)) {
            throw new IllegalStateException("로또번호에 보너스가 포함되어있습니다.");
        }
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
