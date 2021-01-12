package lotto.exception;

public class NumberErrorException extends IllegalArgumentException{
    public NumberErrorException() {
        super("로또 번호를 잘못 입력하셨습니다.");
    }
}
