package lotto.domain;

import java.util.Set;

public class LottoDto {
    private Set<LottoNumber> lottoDto;

    public LottoDto(Set<LottoNumber> lottoNumbers) {
        this.lottoDto = lottoNumbers;
    }

    public Set<LottoNumber> getLottoDto() {
        return lottoDto;
    }
}
