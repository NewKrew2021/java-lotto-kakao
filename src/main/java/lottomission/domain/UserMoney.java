package lottomission.domain;

public class UserMoney {

    private final int userMoney;

    public UserMoney(int userMoney) {
        if (isNegativeValue(userMoney)) {
            throw new IllegalArgumentException("구입금액은 음수가 될 수 없습니다.");
        }
        this.userMoney = userMoney;
    }

    public int getUserMoney(){
        return this.userMoney;
    }

    private boolean isNegativeValue(int userMoney) {
        return userMoney < 0;
    }

    public boolean isUserMoneyZero(){
        return this.userMoney == 0;
    }

    public int getPossibleCount() {
        return userMoney/ LottoGame.LOTTO_PRICE;
    }

    public UserMoney getLeftUserMoney(int lottoCount){
        return new UserMoney(userMoney - lottoCount * LottoGame.LOTTO_PRICE);
    }
}
