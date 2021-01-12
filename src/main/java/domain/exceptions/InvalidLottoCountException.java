package domain.exceptions;

public class InvalidLottoCountException extends RuntimeException {

  public InvalidLottoCountException(String message) {
    super(message);
  }
}
