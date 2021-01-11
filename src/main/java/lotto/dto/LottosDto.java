package lotto.dto;

import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosDto {

    private final List<LottoDto> lottos;

    public LottosDto(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    public static LottosDto from(Lottos lottosObj) {
        return new LottosDto(lottosObj.getLottos()
                .stream()
                .map(LottoDto::from)
                .collect(Collectors.toList()));
    }

    public List<LottoDto> getLottoDtos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottos.forEach(lotto -> {
            stringBuilder.append(lotto.toString()).append("\n");
        });
        return stringBuilder.toString();
    }
}
