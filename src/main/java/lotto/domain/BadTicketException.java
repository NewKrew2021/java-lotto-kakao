package lotto.domain;

public class BadTicketException extends RuntimeException {

    public BadTicketException(String message) {
        super(message);
    }
}
