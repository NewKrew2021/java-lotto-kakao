package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Set;

public class ManualNumberGenerator {

    public static Set<LottoNumber> generate(String numberText) {
        return LottoNumberParser.toLottoNumbers(numberText);
    }
}
