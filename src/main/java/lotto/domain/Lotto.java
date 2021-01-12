package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> digits) {
        if (isInvalidNumberOfDigits(digits)) {
            throw new IllegalArgumentException("숫자는 6개만 입력해주세요.");
        }
        if (isDuplicate(digits)) {
            throw new IllegalArgumentException("숫자는 중복되지 않게 입력해주세요.");
        }
        Collections.sort(digits);
        this.lottoNumbers = digits;
    }

    public Lotto(String text) {
        lottoNumbers = new ArrayList<>();
        for (String number : text.split(", ")) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private boolean isDuplicate(List<LottoNumber> digits) {
        return digits.stream()
                .distinct()
                .count() != digits.size();
    }

    private boolean isInvalidNumberOfDigits(List<LottoNumber> digits) {
        return digits.size() != 6;
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
