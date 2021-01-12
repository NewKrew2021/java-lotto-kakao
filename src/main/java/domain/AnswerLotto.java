package domain;

import java.util.*;
import java.util.stream.Collectors;

public class AnswerLotto {
    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public AnswerLotto(Lotto answerLotto, LottoNumber bonusNumber) {
        checkLottoHasBonus(answerLotto, bonusNumber);
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoStatus getResult(Lotto lotto) {
        return LottoStatus.findStatus(getMatchingNumber(lotto.getLotto()), isMatchedBonusNumber(lotto.getLotto()));
    }

    private boolean isMatchedBonusNumber(List<LottoNumber> lotto) {
        return lotto.contains(bonusNumber);
    }

    private int getMatchingNumber(List<LottoNumber> lotto) {
        return lotto.stream()
                .filter(answerLotto::contains)
                .collect(Collectors.toList()).size();
    }

    private void checkLottoHasBonus(Lotto answerLotto, LottoNumber bonus) {
        if (answerLotto.contains(bonus)) {
            throw new LottoException("로또번호에 보너스가 포함되어있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerLotto that = (AnswerLotto) o;
        return Objects.equals(answerLotto, that.answerLotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerLotto, bonusNumber);
    }
}

