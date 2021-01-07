package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserBuyNumbers {

    private static final int USER_BUY_NUMBERS_SIZE = 6;

    private final List<LottoNumber> userBuyNumbers;

    public UserBuyNumbers(List<Integer> userBuyNumbers) {
        validateUserBuyNumbers(userBuyNumbers);
        this.userBuyNumbers = new ArrayList<>();
        for (Integer winNum : userBuyNumbers) {
            this.userBuyNumbers.add(new LottoNumber(winNum));
        }
    }

    private void validateUserBuyNumbers(List<Integer> userBuyNumbers) {
        if (!isValidSize(userBuyNumbers)) {
            throw new IllegalArgumentException("구매 번호는 6개입니다.");
        }
        if (!isUnique(userBuyNumbers)) {
            throw new IllegalArgumentException("구매 번호는 중복되면 안됩니다.");
        }
    }

    private boolean isValidSize(List<Integer> userBuyNumbers) {
        return userBuyNumbers.size() == USER_BUY_NUMBERS_SIZE;
    }

    private boolean isUnique(List<Integer> userBuyNumbers) {
        return userBuyNumbers.stream().distinct().count() == userBuyNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBuyNumbers that = (UserBuyNumbers) o;
        return Objects.equals(userBuyNumbers, that.userBuyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userBuyNumbers);
    }
}
