package exception;

public class ManualLottoCountExceededException extends RuntimeException{

    public ManualLottoCountExceededException(String msg){
        super(msg);
    }
}
