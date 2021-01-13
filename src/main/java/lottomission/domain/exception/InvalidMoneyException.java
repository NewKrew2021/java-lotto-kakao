package lottomission.domain.exception;

public class InvalidMoneyException extends IllegalArgumentException{
    private static final String INVALID_MONEY_MESSAGE = "구입금액은 양수가 되어야 합니다.";
    public InvalidMoneyException(){
        super(INVALID_MONEY_MESSAGE);
    }
}
