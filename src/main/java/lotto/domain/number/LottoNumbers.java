package lotto.domain.number;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class LottoNumbers {

    public static final String LOTTO_TICKET_EXCEPTION_MESSAGE = "중복된 숫자는 허용되지 않고, 로또 번호의 개수가 6개여야 합니다.";
    public static final int LOTTO_TICKET_LENGTH = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateLength(lottoNumbers);

        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    private void validateLength(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_TICKET_LENGTH) {
            throw new IllegalArgumentException(LOTTO_TICKET_EXCEPTION_MESSAGE);
        }
    }

    public static LottoNumbers from(NumberGenerateStrategy strategy) {
        return from(strategy.generate());
    }

    public static LottoNumbers from(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::valueOf)
                .collect(collectingAndThen(toCollection(TreeSet::new), LottoNumbers::new));
    }

    public int countMatchingNumber(LottoNumbers lottoNumbers) {
        Set<LottoNumber> lottoNumbersA = getLottoNumbers();
        Set<LottoNumber> lottoNumbersB = lottoNumbers.getLottoNumbers();
        Set<LottoNumber> lottoNumbersIntersection = new HashSet<>();

        lottoNumbersIntersection.addAll(lottoNumbersA);
        lottoNumbersIntersection.addAll(lottoNumbersB);

        return (lottoNumbersA.size() + lottoNumbersB.size()) - lottoNumbersIntersection.size();

    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
