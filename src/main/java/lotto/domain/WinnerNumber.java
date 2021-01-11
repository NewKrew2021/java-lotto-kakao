package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerNumber {
    private final Set<Number> numbers;
    private final Number bonusNumber;

    public WinnerNumber(Set<Number> numbers, Number bonusNumber) {
        BallCountChecker.checkBallCount(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerNumber from(String input, int bonusNumber) {
        List<Integer> numbers = stringToIntegerList(input);
        return new WinnerNumber(new TreeSet<Number>(numbers.stream().map(Number::of).collect(Collectors.toList())), Number.of(bonusNumber));
    }

    public LottoRank getRank(LottoTicket lottoTicket) {
        return LottoRank.get(new MatchResult(matchCount(lottoTicket), lottoTicket.contains(bonusNumber)));
    }

    private int matchCount(LottoTicket comparedTicket) {
        return (int) numbers.stream().filter(comparedTicket::contains).count();
    }

    private static List<Integer> stringToIntegerList(String input) {
        return Arrays.stream(preProcessing(input).split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String preProcessing(String input) {
        return input.replaceAll(" ", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerNumber that = (WinnerNumber) o;
        return Objects.equals(numbers, that.numbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, bonusNumber);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]" + " bonusNumber : " + bonusNumber;
    }
}
