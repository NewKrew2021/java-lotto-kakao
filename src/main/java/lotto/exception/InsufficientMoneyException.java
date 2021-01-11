package lotto.exception;

public class InsufficientMoneyException extends RuntimeException {

    public InsufficientMoneyException() {
        super();
    }

    public InsufficientMoneyException(String message) {
        super(message);
    }
}
