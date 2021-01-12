package lotto.domain;

import java.util.Objects;

public class NumOfLotto {
    private final int numOfLotto;

    public NumOfLotto(int numOfLotto) {
        this.numOfLotto = numOfLotto;
        if (!isValid()) {
            throw new IllegalArgumentException("잘못된 구매 개수입니다.");
        }
    }

    public NumOfLotto minus(NumOfLotto other) {
        return new NumOfLotto(getNumOfLotto() - other.getNumOfLotto());
    }

    public int getNumOfLotto() {
        return numOfLotto;
    }

    private boolean isValid() {
        return numOfLotto >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumOfLotto that = (NumOfLotto) o;
        return numOfLotto == that.numOfLotto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfLotto);
    }
}
