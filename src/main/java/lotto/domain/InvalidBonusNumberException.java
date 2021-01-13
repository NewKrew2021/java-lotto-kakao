package lotto.domain;

public class InvalidBonusNumberException extends RuntimeException{
    private static final String INVALID_BONUS_NUMBER = "로또 숫자와 보너스 넘버는 일치하면 안됩니다.";

    public InvalidBonusNumberException(){
        super(INVALID_BONUS_NUMBER);
    }
}
