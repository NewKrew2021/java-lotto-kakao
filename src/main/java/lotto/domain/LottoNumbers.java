package lotto.domain;

import lotto.exception.NumberDuplicateException;
import lotto.exception.NumbersSizeException;

import java.util.*;

public class LottoNumbers {

    public static final int POSSIBLE_NUMBERS_SIZE = 6;
    private static final String SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개입니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복되면 안됩니다.";

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (Integer num : numbers) {
            lottoNumbers.add(LottoNumber.of(num));
        }
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(Set<LottoNumber> numbers) {
        this.lottoNumbers = numbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new NumbersSizeException(SIZE_EXCEPTION_MESSAGE);
        }
        if (!isUnique(numbers)) {
            throw new NumberDuplicateException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isValidSize(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == POSSIBLE_NUMBERS_SIZE;
    }

    private boolean isUnique(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().distinct().count() == lottoNumbers.size();
    }

    public int getMatchCountWith(LottoNumbers lottoNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            if (lottoNumbers.isContains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<String> convertToString() {
        List<String> numbers = new ArrayList<>();
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            numbers.add(lottoNumber.getNumberToString());
        }
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
