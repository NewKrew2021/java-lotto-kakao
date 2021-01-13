package lottomission.domain.exception;

public class InvalidBonusNumberException extends IllegalArgumentException{
    private static String INVALID_BONUS_NUMBER_MESSAGE = "당첨 번호와 보너스 번호가 같을 수 없습니다.";

    public InvalidBonusNumberException(){
        super(INVALID_BONUS_NUMBER_MESSAGE);
    }
}
