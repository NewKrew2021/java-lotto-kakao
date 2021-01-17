package lotto.domain.exceptions;

public class BadTicketException extends RuntimeException {

    public BadTicketException(String message) {
        super(message);
    }
}
