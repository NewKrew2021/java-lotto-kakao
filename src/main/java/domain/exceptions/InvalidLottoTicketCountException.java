package domain.exceptions;

public class InvalidLottoTicketCountException extends RuntimeException{
    public InvalidLottoTicketCountException(String msg) {
        super(msg);
    }
}
