package lotto.domain.number;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoNumbers {

    public static final String LOTTO_TICKET_EXCEPTION_MESSAGE = "중복된 숫자는 허용되지 않고, 로또 번호의 개수가 6개여야 합니다.";
    public static final int LOTTO_TICKET_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateLength(lottoNumbers);

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> distinctNumbers = new HashSet<>(lottoNumbers);
        if (distinctNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_TICKET_EXCEPTION_MESSAGE);
        }
    }

    private void validateLength(List<LottoNumber> lottoNumbers) {
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
                .collect(collectingAndThen(toList(), LottoNumbers::new));
    }

    public int countMatchingNumber(LottoNumbers lottoNumbers) {
        List<LottoNumber> lottoNumbersA = getLottoNumbers();
        List<LottoNumber> lottoNumbersB = lottoNumbers.getLottoNumbers();
        Set<LottoNumber> lottoNumbersIntersection = new HashSet<>();
        lottoNumbersIntersection.addAll(lottoNumbersA);
        lottoNumbersIntersection.addAll(lottoNumbersB);

        return (lottoNumbersA.size() + lottoNumbersB.size()) - lottoNumbersIntersection.size();

    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
