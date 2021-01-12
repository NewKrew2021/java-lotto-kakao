package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosDtoTest {

    @Test
    @DisplayName("Lottos와 동일한 값을 가지는 LottosDto를 생성한다.")
    void create() {
        Lotto lotto1 = Lotto.autoGenerate(() -> Set.of(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
        Lotto lotto2 = Lotto.autoGenerate(() -> Set.of(1, 2, 3, 10, 11, 12).stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));

        LottosDto lottosDto = LottosDto.from(new Lottos(List.of(lotto1, lotto2)));

        List<Integer> actual = lottosDto.getLottoDtos().stream()
                .flatMap(lottoDto -> lottoDto.getLotto().stream())
                .collect(Collectors.toList());
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 1, 2, 3, 10, 11, 12);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
