package domain;

public class InvalidMoneyException extends RuntimeException {
    InvalidMoneyException(String message) {
        super(message);
    }
}
