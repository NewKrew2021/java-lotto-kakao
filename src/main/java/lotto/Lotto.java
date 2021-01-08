package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public static final int COUNT_OF_NUMBERS = 6;

    private final List<Ball> lottoBalls;

    public Lotto(String lottoText) {
        List<Ball> lottoNumbers = parseLottoText(lottoText);

        checkDuplicate(lottoNumbers);
        checkCount(lottoNumbers);

        this.lottoBalls = lottoNumbers;
    }

    private void checkDuplicate(List<Ball> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() < lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호 중복이 있어서는 안된다.");
        }
    }

    private void checkCount(List<Ball> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
    }

    public Lotto(GenerateStrategy strategy) {
        this.lottoBalls = strategy.generate().stream()
                .map(Ball::createBall)
                .collect(Collectors.toList());
    }

    private List<Ball> parseLottoText(String lottoText) {
        return Arrays.stream(lottoText.split(","))
                .map(String::trim)
                .map(Ball::createBall)
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
        return lottoBalls.stream()
                .sorted()
                .map(Ball::toString)
                .collect(Collectors.joining(", "));
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
