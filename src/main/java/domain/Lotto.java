package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int BASE_LOTTO_LENGTH = 6;
    public static final int LOTTO_PRICE = 1000;
    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        checkLottoLength(lotto);
        for (int number : lotto) {
            this.lotto.add(new LottoNumber(number));
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    private void checkLottoLength(List<Integer> lotto) {
        if (lotto.size() != BASE_LOTTO_LENGTH) {
            throw new InvalidLottoException("로또의 길이가 6이 아닙니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(number));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("[")
                .append(lotto.stream().map(Object::toString).collect(Collectors.joining(",")))
                .append("]");
        return stringBuilder.toString();
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
}

