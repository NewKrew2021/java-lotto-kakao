package exception;

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException(int num) {
        super(num + "");
    }

    @Override
    public String getMessage() {
        return "숫자가 잘못되었습니다 : " + super.getMessage();
    }
}
