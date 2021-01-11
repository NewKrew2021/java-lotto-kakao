package lotto.exception;

public class BonusNumberException extends IllegalArgumentException {
    public BonusNumberException() {
        super("보너스 번호를 잘못 입력하셨습니다.");
    }
}
