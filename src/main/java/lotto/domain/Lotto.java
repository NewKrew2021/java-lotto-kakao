package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (isInvalidNumberOfDigits(lottoNumbers)) {
            throw new IllegalArgumentException("숫자는 6개만 입력해주세요.");
        }
        if (isDuplicate(lottoNumbers)) {
            throw new IllegalArgumentException("숫자는 중복되지 않게 입력해주세요.");
        }
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(String text) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : text.split(",")) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return new Lotto(lottoNumbers);
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
