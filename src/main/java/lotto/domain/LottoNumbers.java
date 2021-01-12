package lotto.domain;

import lotto.exception.NumberDuplicateException;
import lotto.exception.NumbersSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    static final int POSSIBLE_NUMBERS_SIZE = 6;
    private static final String SIZE_EXCEPTION_MESSAGE = "로또 번호는 "+POSSIBLE_NUMBERS_SIZE+"개입니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복되면 안됩니다.";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.lottoNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            this.lottoNumbers.add(LottoNumber.of(num));
        }
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

    public int getMatchCount(LottoNumbers lottoNumbers) {
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
