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
        return getRank(winCount, bonusCount);
    }

    private Rank getRank(int winCount, int bonusCount) {
        if (winCount == 6) {
            return Rank.FIRST;
        }
        if (winCount == 5 && bonusCount == 1) {
            return Rank.SECOND;
        }
        if (winCount == 5) {
            return Rank.THIRD;
        }
        if (winCount == 4) {
            return Rank.FOURTH;
        }
        if (winCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.NOTHING;
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream().map(LottoNumber::getNumber)
                .map(no -> Integer.toString(no))
                .collect(Collectors.joining(", ")) + "]";
    }
}
