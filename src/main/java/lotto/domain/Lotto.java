package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public static final int COUNT_OF_NUMBERS = 6;

    private final List<LottoNumber> lottoLottoNumbers;

    public Lotto(String lottoText) {
        List<LottoNumber> lottoNumbers = parseLottoText(lottoText);

        checkDuplicate(lottoNumbers);
        checkCount(lottoNumbers);

        this.lottoLottoNumbers = lottoNumbers;
    }

    private void checkDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() < lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호 중복이 있어서는 안된다.");
        }
    }

    private void checkCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
    }

    public Lotto(GenerateStrategy strategy) {
        this.lottoLottoNumbers = strategy.generate().stream()
                .map(LottoNumber::createLottoNumber)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> parseLottoText(String lottoText) {
        return Arrays.stream(lottoText.split(","))
                .map(String::trim)
                .map(LottoNumber::createLottoNumber)
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoLottoNumbers.contains(lottoNumber);
    }

    public Rank compareWithWinning(WinningNumberSet winningNumberSet) {
        return winningNumberSet.compare(lottoLottoNumbers);
    }

    public int compareWithLottoNumbers(List<LottoNumber> counterLottoNumbers) {
        return 2 * COUNT_OF_NUMBERS
                - (int) Stream.concat(lottoLottoNumbers.stream(), counterLottoNumbers.stream()).distinct().count();
    }

    @Override
    public String toString() {
        return lottoLottoNumbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoLottoNumbers, lotto.lottoLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoLottoNumbers);
    }
}
