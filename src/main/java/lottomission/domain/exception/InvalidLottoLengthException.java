package lottomission.domain.exception;

public class InvalidLottoLengthException extends IllegalArgumentException{
    private static String INVALID_LOTTO_LENGTH_MESSAGE = "로또는 중복 없이 6개의 숫자로 이루어 져야 합니다.";

    public InvalidLottoLengthException(){
        super(INVALID_LOTTO_LENGTH_MESSAGE);
    }
}
