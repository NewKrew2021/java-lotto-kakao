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
