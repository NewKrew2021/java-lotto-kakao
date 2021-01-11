package lotto.dto;

import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosDto {

    private List<LottoDto> lottoDtos;

    private LottosDto(List<LottoDto> lottoDtos) {
        this.lottoDtos = lottoDtos;
    }

    public static LottosDto from(Lottos lottos) {
        return new LottosDto(lottos.getLottos()
                .stream()
                .map(LottoDto::from)
                .collect(Collectors.toList()));
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }
}
