package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.util.MatchResult;
import lotto.util.Rank;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberGenerator lottoNumberGenerator) {
        lottoNumbers = new TreeSet<>(Comparator.comparingInt(LottoNumber::getNumber));
        for (int l : lottoNumberGenerator.getNumbers()) {
            lottoNumbers.add(LottoNumber.of(l));
        }
    }

    public Rank match(MatchNumber matchNumber) {
        int winCount = (int) lottoNumbers.stream()
                .map(matchNumber::getMatchResult)
                .filter(matchResult -> matchResult.equals(MatchResult.WIN))
                .count();
        int bonusCount = (int) lottoNumbers.stream()
                .map(matchNumber::getMatchResult)
                .filter(matchResult -> matchResult.equals(MatchResult.BONUS))
                .count();
        return Rank.of(winCount, bonusCount);
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream().map(LottoNumber::getNumber)
                .map(no -> Integer.toString(no))
                .collect(Collectors.joining(", ")) + "]";
    }
}
