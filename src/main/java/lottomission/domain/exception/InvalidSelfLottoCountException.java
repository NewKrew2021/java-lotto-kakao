package lottomission.domain.exception;

public class InvalidSelfLottoCountException extends IllegalArgumentException{
    private static String INVALID_SELF_LOTTO_COUNT_MESSAGE = "입력하신만큼 수동으로 살 수 없습니다.";

    public InvalidSelfLottoCountException(){
        super(INVALID_SELF_LOTTO_COUNT_MESSAGE);
    }
}
