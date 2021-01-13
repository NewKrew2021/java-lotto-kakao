package lottomission.domain;

import lottomission.domain.exception.InvalidMoneyException;

public class UserMoney {

    private final int userMoney;

    public UserMoney(int userMoney) {
        if (isNotPositiveValue(userMoney)) {
            throw new InvalidMoneyException();
        }
        this.userMoney = userMoney;
    }

    public int getUserMoney(){
        return this.userMoney;
    }

    private boolean isNotPositiveValue(int userMoney) {
        return userMoney <= 0;
    }

    public int getPossibleCount() {
        return userMoney/ LottoGame.LOTTO_PRICE;
    }
}
