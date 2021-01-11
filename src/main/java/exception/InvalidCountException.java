package exception;

public class InvalidCountException extends RuntimeException {

    public InvalidCountException(int num) {
        super(num + "");
    }

    @Override
    public String getMessage() {
        return "로또 숫자가 잘못되었습니다 : " + super.getMessage();
    }
}
