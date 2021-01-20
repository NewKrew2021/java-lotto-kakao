package lotto.exception;

public class WrongMoneyInputException extends RuntimeException {

    public static String WRONG_MONEY_INPUT_EXCEPTION = "잘못 된 금액을 입력하셨습니다.";


    public WrongMoneyInputException() {
        super(WRONG_MONEY_INPUT_EXCEPTION);
    }

}
