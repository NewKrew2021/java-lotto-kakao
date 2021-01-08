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

//    public List<Integer> checkLottoResult(WinAndBonusNumbers winAndBonusNumbers) {
//        List<RankState> rankStates = new ArrayList<>();
//        for (LottoNumbers lottoNumbers : userBuyNumbers) {
//            rankStates.add(lottoNumbers.calculateRank(winAndBonusNumbers));
//        }
//        return tansformToWinCount(rankStates);
//    }

    public List<List<String>> convertToString() {
        List<List<String>> allNumbers = new ArrayList<>();
        for (LottoNumbers lottoNumbers : userBuyNumbers) {
            allNumbers.add(lottoNumbers.convertToString());
        }
        return allNumbers;
    }
}
