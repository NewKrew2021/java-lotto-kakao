package lotto.view;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersDto {
    private final List<Integer> lottoNumbers;

    private LottoNumbersDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbersDto from(LottoNumbers lottoNumbers) {
        return lottoNumbers.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbersDto::new));
    }


    public List<Integer> getSortedLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
