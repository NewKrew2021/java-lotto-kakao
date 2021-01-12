package lotto.domain;

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
}
