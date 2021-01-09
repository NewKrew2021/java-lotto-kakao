package domain.exceptions;

public class InvalidLottoNumberException extends RuntimeException{
    public InvalidLottoNumberException(String msg) {
        super(msg);
    }
}
