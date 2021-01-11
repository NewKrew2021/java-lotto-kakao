package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LottoDto {
    private Set<LottoNumberDto> lottoNumberDtos;

    private LottoDto(Set<LottoNumberDto> lottoNumberDtos) {
        this.lottoNumberDtos = lottoNumberDtos;
    }

    public static LottoDto from(Lotto lotto) {
        Set<LottoNumberDto> newLottoNumberDtos = new TreeSet<>(
                Comparator.comparingInt(LottoNumberDto::getNumber));
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            newLottoNumberDtos.add(LottoNumberDto.from(lottoNumber));
        }
        return new LottoDto(newLottoNumberDtos);
    }

    public Set<LottoNumberDto> getLottoNumbers() {
        return lottoNumberDtos;
    }
}
