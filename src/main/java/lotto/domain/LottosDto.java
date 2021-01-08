package lotto.domain;

import java.util.List;

public class LottosDto {
    private List<LottoDto> lottosDto;

    public LottosDto(List<LottoDto> lottos) {
        this.lottosDto = lottos;
    }

    public List<LottoDto> getLottosDto() {
        return lottosDto;
    }
}
