package LottoMission;

public class UserMoney {

    private final int userMoney;

    public UserMoney(int usermoney) {
        if(isNotPositive(usermoney)){
            throw new IllegalArgumentException("구입금액은 양수가 되어야 합니다.");
        }
        this.userMoney = usermoney;
    }

    private boolean isNotPositive(int userMoney) {
        return userMoney <= 0;
    }

    public int getUserMoney() {
        return userMoney;
    }

}
