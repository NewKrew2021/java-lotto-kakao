package lotto.domain;

public class Amount {
    private final int LOTTO_PRICE = 1000;

    private int money;

    public Amount(int money) {
        if(money<1000){
            throw new IllegalArgumentException("로또를 구매할 수 없는 금액입니다.");
        }
        this.money = money;
    }

    public int BuyCount(){
        return money/LOTTO_PRICE;
    }
}
