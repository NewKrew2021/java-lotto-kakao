package exception;

public class UnderLottoBuyAmountException extends RuntimeException{

    public UnderLottoBuyAmountException(String msg){
        super(msg);
    }
}
