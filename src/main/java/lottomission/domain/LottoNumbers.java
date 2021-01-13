package lottomission.domain;

import lottomission.domain.exception.InvalidLottoLengthException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final Set<LottoNumber> numbers;
    public static final int MAX_NUMBERS_LENGTH = 6;

    public LottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> temp = new HashSet<>();
        for (int number : numbers) {
            temp.add(new LottoNumber(number));
        }

        if (checkNumbersLength(temp)) {
            throw new InvalidLottoLengthException();
        }
        this.numbers = temp;
    }

    private boolean checkNumbersLength(Set<LottoNumber> temp) {
        return temp.size() != MAX_NUMBERS_LENGTH;
    }

    public boolean isContainLottoNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int getCombineSetLength(LottoNumbers lottoNumbers) {
        return lottoNumbers.combineTwoLottoNumberSet(this.numbers).size();
    }

    public Set<LottoNumber> combineTwoLottoNumberSet(Set<LottoNumber> lottoNumbers){
        Set<LottoNumber> combineSet = new HashSet<>(this.numbers);
        combineSet.addAll(lottoNumbers);
        return combineSet;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getNumbersList() {
        return numbers
                .stream()
                .map(i -> i.getNumber())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
