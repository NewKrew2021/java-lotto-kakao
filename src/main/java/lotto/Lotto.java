package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    public static final int COUNT_OF_NUMBERS = 6;

    private final List<Ball> lottoBalls;

    public Lotto(String lottoText) {
        List<Ball> lottoNumbers = parseLottoText(lottoText);

        if (lottoNumbers.stream().distinct().count() < lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호 중복이 있어서는 안된다.");
        }

        if (lottoNumbers.size() > COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }

        this.lottoBalls = lottoNumbers;
    }

    public Lotto(GenerateStrategy strategy) {
        this.lottoBalls = strategy.generate().stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }


    private List<Ball> parseLottoText(String lottoText) {
        return Arrays.stream(lottoText.split(","))
                .map(String::trim)
                .map(Ball::new)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoBalls, lotto.lottoBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBalls);
    }
}
