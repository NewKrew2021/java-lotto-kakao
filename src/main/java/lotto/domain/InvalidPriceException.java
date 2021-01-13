package lotto.domain;

public class InvalidPriceException extends RuntimeException{
    private static final String INVALID_PRICE = "로또를 구매할 가격이 부족합니다. 1000원이상 입력해주세요.";

    public InvalidPriceException(){
        super(INVALID_PRICE);
    }
}
