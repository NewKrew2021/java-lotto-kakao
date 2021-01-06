package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(String lottoText) {
        List<Integer> lottoNumbers = parseLottoText(lottoText);

        if (lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber <= 0 || lottoNumber > 45)) {
            throw new IllegalArgumentException("로또번호는 1 이상, 45 이하여야 한다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> parseLottoText(String lottoText) {
        return Arrays.asList(lottoText.split(",")).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
