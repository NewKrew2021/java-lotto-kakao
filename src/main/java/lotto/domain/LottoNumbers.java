package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT_IN_ONE_TICKET = 6;
    List<LottoNumber> numbers = new ArrayList<>();

    public LottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("갯수는 "+LOTTO_NUMBER_COUNT_IN_ONE_TICKET+"개 이어야 합니다.");
        }

        if (checkDuplication(numbers)) {
            throw new IllegalArgumentException("중복된 숫자가 존재하면 안됩니다.");
        }

        for (int number : numbers) {
            this.numbers.add(new LottoNumber(number));
        }
    }

    private boolean checkDuplication(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            set.add(numbers.get(i));
        }
        if (set.size() != numbers.size())
            return true;
        return false;
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public int getMatchCount(LottoNumbers lottoNumbers) {
        return this.numbers.stream()
                .filter((lottoNo) -> lottoNumbers.isContains(lottoNo))
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
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
}
