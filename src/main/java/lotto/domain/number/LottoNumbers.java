package lotto.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final String LOTTO_TICKET_EXCEPTION_MESSAGE = "중복된 숫자는 허용되지 않고, 로또 번호의 개수가 6개여야 합니다.";
    public static final int LOTTO_TICKET_LENGTH = 6;
    //List 보단 Set 이 나을 것 같다는 생, 또한 입력된 번호는 모두 정렬되어있어야 한다.
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateLength(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(NumberGenerateStrategy strategy) {
        List<LottoNumber> lottoNumbers = strategy.generate().stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
    //Duplicate를 Set으로 줄일 수 있음. (첨부터 없는 과정으로 할 수 있을 것이라 보임
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
