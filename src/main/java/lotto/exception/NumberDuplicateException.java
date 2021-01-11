package lotto.exception;

public class NumberDuplicateException extends RuntimeException {

    public NumberDuplicateException() {
        super();
    }

    public NumberDuplicateException(String message) {
        super(message);
    }
}
