package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerNumber {
    private LottoTicket numbers;
    private final Number bonusNumber;

    public WinnerNumber(LottoTicket numbers, Number bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerNumber from(String input, int bonusNumber) {
        return new WinnerNumber(LottoTicket.from(input), Number.of(bonusNumber));
    }

    public LottoRank getRank(LottoTicket lottoTicket) {
        return LottoRank.get(new MatchResult(numbers.matchCount(lottoTicket), lottoTicket.contains(bonusNumber)));
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
        return numbers + " bonusNumber : " + bonusNumber;
    }
}
