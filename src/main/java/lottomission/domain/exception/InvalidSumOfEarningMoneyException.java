package lottomission.domain.exception;

public class InvalidSumOfEarningMoneyException extends RuntimeException{
    private static String INVALID_SUM_OF_EARNING_MONEY_MESSAGE = "총 수익이 음수가 될 수 없습니다.";

    public InvalidSumOfEarningMoneyException(){
        super(INVALID_SUM_OF_EARNING_MONEY_MESSAGE);
    }
}
