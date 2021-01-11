package exception;

public class InvalidPriceException extends RuntimeException {

    public InvalidPriceException(int price) {
        super(price + "");
    }

    @Override
    public String getMessage() {
        return "가격이 잘못되었습니다 : " + super.getMessage();
    }
}
