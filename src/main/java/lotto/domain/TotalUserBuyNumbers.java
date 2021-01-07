package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TotalUserBuyNumbers {

    private List<UserBuyNumbers> totalUserBuyNumbers;

    public TotalUserBuyNumbers() {
        this.totalUserBuyNumbers = new ArrayList<>();
    }

    public void addBuyNumbers(UserBuyNumbers userBuyNumbers) {
        this.totalUserBuyNumbers.add(userBuyNumbers);
    }

    public List<RankState> getAllRankResult(WinAndBonusNumbers winAndBonusNumbers) {
        List<RankState> winResult = new ArrayList<>();
        for (UserBuyNumbers totalUserBuyNumber : totalUserBuyNumbers) {
            winResult.add(totalUserBuyNumber.calculateRank(winAndBonusNumbers));
        }
        return winResult;
    }

    public List<List<String>> convertToString() {
        List<List<String>> allNumbers = new ArrayList<>();
        for (UserBuyNumbers userBuyNumbers : totalUserBuyNumbers) {
            allNumbers.add(userBuyNumbers.convertToString());
        }
        return allNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalUserBuyNumbers that = (TotalUserBuyNumbers) o;
        return Objects.equals(totalUserBuyNumbers, that.totalUserBuyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalUserBuyNumbers);
    }
}
