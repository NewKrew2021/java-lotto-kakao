package lotto.utils;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPickStrategy implements NumberPickStrategy {
    @Override
    public List<LottoNumber> generateLottoNumbers() {
        List<LottoNumber> digits = IntStream
            .rangeClosed(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        Collections.shuffle(digits);

        return digits.stream()
                .limit(LottoNumbers.ALLOWED_NUMBER_COUNT)
                .collect(Collectors.toList());
    }
}
