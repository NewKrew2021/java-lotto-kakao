package lotto.exception;

public class OutOfRangeException extends IllegalArgumentException{
    public OutOfRangeException(String text){
        super(text);
    }
}
