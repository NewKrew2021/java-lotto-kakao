package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class UserBuyNumbers {

    private final List<LottoNumbers> userBuyNumbers;

    public UserBuyNumbers() {
        this.userBuyNumbers = new ArrayList<>();
    }

    public void addBuyNumbers(LottoNumbers lottoNumbers) {
        this.userBuyNumbers.add(lottoNumbers);
    }

    public List<RankState> checkLottoResult(WinningNumbers winningNumbers) {
        List<RankState> rankStates = new ArrayList<>();
        for (LottoNumbers lottoNumbers : this.userBuyNumbers) {
            int matchCount = lottoNumbers.getMatchCount(winningNumbers.getWinNumbers());
            boolean bonusMatched = lottoNumbers.isContains(winningNumbers.getBonusNumber());
            rankStates.add(RankState.rank(matchCount, bonusMatched));
        }
        return rankStates;
    }

    @Override
    public String toString() {
        return userBuyNumbers.stream()
                .map(LottoNumbers::toString)
                .collect(joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBuyNumbers that = (UserBuyNumbers) o;
        return java.util.Objects.equals(userBuyNumbers, that.userBuyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userBuyNumbers);
    }
}
