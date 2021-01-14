package lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_MIN_INT = 1;
    private static final int LOTTO_MAX_INT = 45;
    private final int number;

    private static final Map<Integer, LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_INT, LOTTO_MAX_INT)
            .boxed()
            .collect(toMap(Function.identity(), LottoNumber::new));

    static {
        for (int i = LOTTO_MIN_INT; i <= LOTTO_MAX_INT; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber of(int number) {
        if (number > LOTTO_MAX_INT || number < LOTTO_MIN_INT) {
            throw new IllegalArgumentException("1~45범위를 벗어난 숫자입니다.");
        }
        return lottoNumbers.get(number);
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public static List<LottoNumber> generateLottoNumbers(int amount) {
        List<LottoNumber> numbers = lottoNumbers.values()
                                                .stream()
                                                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, amount);
        Collections.sort(numbers);
        return numbers;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
