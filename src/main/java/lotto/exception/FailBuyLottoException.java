package lotto.exception;

public class FailBuyLottoException extends IllegalArgumentException{
    public FailBuyLottoException(){
        super("돈이 부족합니다.");
    }
}
