package lotto.exception;

public class TooLowMoneyException extends IllegalArgumentException{
    public TooLowMoneyException(String text) {
        super(text);
    }
}
