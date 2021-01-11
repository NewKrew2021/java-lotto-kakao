package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            int matchCount = lottoNumbers.getMatchCountWith(winningNumbers.getWinNumbers());
            boolean bonusMatched = lottoNumbers.isContains(winningNumbers.getBonusNumber());
            rankStates.add(CalculateRank(matchCount, bonusMatched));
        }
        return rankStates;
    }

    private RankState CalculateRank(int matchCount, boolean bonusMatched) {
        if (matchCount == 6)
            return RankState.FIRST;
        if (matchCount == 5 && bonusMatched)
            return RankState.SECOND;
        if (matchCount == 5)
            return RankState.THIRD;
        if (matchCount == 4)
            return RankState.FOURTH;
        if (matchCount == 3)
            return RankState.FIFTH;
        return RankState.FAIL;
    }

    public List<List<String>> convertToString() {
        List<List<String>> allNumbers = new ArrayList<>();
        for (LottoNumbers lottoNumbers : userBuyNumbers) {
            allNumbers.add(lottoNumbers.convertToString());
        }
        return allNumbers;
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
