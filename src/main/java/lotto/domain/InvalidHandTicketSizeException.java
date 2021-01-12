package lotto.domain;

public class InvalidHandTicketSizeException extends RuntimeException{
    private static final String INVALID_TICKET_SIZE = "수동으로 구입하려는 장수 너무 많습니다.";

    public InvalidHandTicketSizeException(){
        super(INVALID_TICKET_SIZE);
    }
}
