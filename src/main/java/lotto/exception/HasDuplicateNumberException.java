package lotto.exception;

public class HasDuplicateNumberException extends IllegalArgumentException {
    public HasDuplicateNumberException() {
        super("로또 번호를 잘못 입력하셨습니다.");
    }
}
