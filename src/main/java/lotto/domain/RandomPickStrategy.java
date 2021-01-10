package lotto.domain;

import lotto.domain.dto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPickStrategy implements NumberPickStrategy {
    private final List<LottoNumber> digits = IntStream
            .rangeClosed(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
            .boxed()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList());

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(digits);
        return digits.stream()
                .limit(LottoNumbers.ALLOWED_NUMBER_COUNT)
                .collect(Collectors.toList());
    }
}
