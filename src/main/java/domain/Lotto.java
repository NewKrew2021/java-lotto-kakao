package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int BASE_LOTTO_LENGTH = 6;
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        lottoLengthNotSatisfied(lotto);
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    private void lottoLengthNotSatisfied(List<Integer> lotto) {
        if (lotto.size() != BASE_LOTTO_LENGTH) {
            throw new IllegalStateException("로또의 길이가 6이 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(lotto.stream().map(Object::toString).collect(Collectors.joining(",")));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
