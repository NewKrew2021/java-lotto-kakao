package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public static final int COUNT_OF_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


    public static Lotto createLottoWithText(String lottoText) {
        List<LottoNumber> lottoNumbers = parseLottoText(lottoText);

        checkDuplicate(lottoNumbers);
        checkCount(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public static Lotto createLottoRandomly(GenerateStrategy strategy) {
        return new Lotto(strategy.generate().stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList()));
    }

    private static void checkDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() < lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호 중복이 있어서는 안된다.");
        }
    }

    private static void checkCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
    }

    private static List<LottoNumber> parseLottoText(String lottoText) {
        return Arrays.stream(lottoText.split(","))
                .map(String::trim)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Rank compareWithWinning(WinningNumberSet winningNumberSet) {
        return winningNumberSet.compareWithLotto(this);
    }

    public int compareWithCounter(Lotto lotto) {
        return lotto.compareWithLottoNumbers(lottoNumbers);
    }

    public int compareWithLottoNumbers(List<LottoNumber> counterLottoNumbers) {
        return 2 * COUNT_OF_NUMBERS
                - (int) Stream.concat(lottoNumbers.stream(), counterLottoNumbers.stream()).distinct().count();
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));
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
