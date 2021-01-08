package lotto.exception;

public class InvalidNumberException extends RuntimeException{
    private static final String INVALID_NUMBER = "숫자가 잘못되었습니다";
    public InvalidNumberException(){
        System.out.println(INVALID_NUMBER);
    }
}
