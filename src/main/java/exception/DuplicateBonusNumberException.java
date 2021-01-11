package exception;

public class DuplicateBonusNumberException extends RuntimeException {

    public DuplicateBonusNumberException(String num) {
        super(num + "");
    }

    @Override
    public String getMessage() {
        return "보너스 숫자가 중복되었습니다 : " + super.getMessage();
    }
}
