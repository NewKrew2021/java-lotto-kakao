package lotto.exception;

public class BonusDuplicateException extends RuntimeException {

    public BonusDuplicateException() {
        super();
    }

    public BonusDuplicateException(String message) {
        super(message);
    }
}
