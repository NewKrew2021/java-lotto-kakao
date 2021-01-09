package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserBuyNumbers {

    private List<LottoNumbers> userBuyNumbers;

    public UserBuyNumbers() {
        this.userBuyNumbers = new ArrayList<>();
    }

    public void addBuyNumbers(LottoNumbers lottoNumbers) {
        this.userBuyNumbers.add(lottoNumbers);
    }

    public List<RankState> checkLottoResult(WinAndBonusNumbers winAndBonusNumbers) {
        List<RankState> rankStates = new ArrayList<>();
        for (LottoNumbers lottoNumbers : this.userBuyNumbers) {
            int matchCount = lottoNumbers.getMatchCountWith(winAndBonusNumbers.getWinNumbers());
            boolean bonusMatched = lottoNumbers.isContains(winAndBonusNumbers.getBonusNumber());
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
}
