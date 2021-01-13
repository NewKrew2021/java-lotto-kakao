package lottomission.domain.exception;

public class InvalidLottoNumberException extends IllegalArgumentException{
    private static String INVALID_LOTTO_NUMBER_MESSAGE = "숫자는 1~45 에 포함 되어야 합니다";

    public InvalidLottoNumberException(){
        super(INVALID_LOTTO_NUMBER_MESSAGE);
    }
}
