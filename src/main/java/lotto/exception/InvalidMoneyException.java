package lotto.exception;

public class InvalidMoneyException extends RuntimeException{

    private static final String MSG_WRONG_MONEY_VALUE = "돈은 음수가 될 수 없습니다.";

    public InvalidMoneyException() {
        this(MSG_WRONG_MONEY_VALUE);
    }

    public InvalidMoneyException(String message) {
        super(message);
    }
}
