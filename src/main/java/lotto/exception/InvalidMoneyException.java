package lotto.exception;

public class InvalidMoneyException extends RuntimeException {

    private static final String MSG_WRONG_MONEY_VALUE = "돈은 로또 가격보다 낮을 수 없습니다.";

    public InvalidMoneyException() {
        super(MSG_WRONG_MONEY_VALUE);
    }

}
