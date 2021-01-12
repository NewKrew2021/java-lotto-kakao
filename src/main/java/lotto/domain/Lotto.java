package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    public static final int COUNT_OF_NUMBERS = 6;
    private static final String LOTTO_DUPLICATE_EXCEPTION_MESSAGE = "로또번호 중복이 있어서는 안된다.";
    private static final String LOTTO_COUNT_EXCEPTION_MESSAGE = "로또번호는 %d개여야 한다.";
    private final List<Ball> lottoBalls;

    public Lotto() {
        this.lottoBalls = LottoNumberPool.autoGenerate().stream()
                .map(Ball::of)
                .collect(Collectors.toList());
    }

    public Lotto(String lottoText) {
        List<Ball> lottoNumbers = parseLottoText(lottoText);
        checkDuplicate(lottoNumbers);
        checkCount(lottoNumbers);
        this.lottoBalls = lottoNumbers;
    }

    public void checkDuplicate(List<Ball> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() < lottoNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public void checkCount(List<Ball> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException(String.format(LOTTO_COUNT_EXCEPTION_MESSAGE, COUNT_OF_NUMBERS));
        }
    }

    public List<Ball> parseLottoText(String lottoText) {
        return Arrays.stream(lottoText.split(","))
                .map(String::trim)
                .map(Ball::of)
                .collect(Collectors.toList());
    }

    public boolean contains(Ball ball) {
        return lottoBalls.contains(ball);
    }

    public Rank compareWithWinning(WinningNumberSet winningNumberSet) {
        return winningNumberSet.compare(lottoBalls);
    }

    public int compareWithBalls(List<Ball> counterBalls) {
        return 2 * COUNT_OF_NUMBERS
                - (int) Stream.concat(lottoBalls.stream(), counterBalls.stream()).distinct().count();
    }

    @Override
    public String toString() {
        return "[" + lottoBalls.stream()
                .sorted()
                .map(Ball::toString)
                .collect(Collectors.joining(", ")) + "]";
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
