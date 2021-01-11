package lotto.exception;

public class TooLowMoneyException extends IllegalArgumentException {
    public TooLowMoneyException(int money) {
        super(money + "원 이상의 금액을 입력해 주세요");
    }
}
