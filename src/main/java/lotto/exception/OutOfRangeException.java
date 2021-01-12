package lotto.exception;

public class OutOfRangeException extends IllegalArgumentException {
    public OutOfRangeException() {
        super("잘못된 숫자를 입력하셨습니다.");
    }
}
