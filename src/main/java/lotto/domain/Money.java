package lotto.domain;

import static lotto.util.StringUtils.*;

public class Money {
    private int money;

    private static final int LOTTO_PRICE = 1_000;

    private Money(int money){
        this.money = money;
    }

    public static Money makeMoney(int money){
        if(money < LOTTO_PRICE)
            throw new IllegalArgumentException("가격이 부족합니다.");

        return new Money(money);
    }

    public static Money makeMoneyFromText(String money){
        if(isBlank(money) || !isNumber(money))
            throw new IllegalArgumentException("숫자를 입력하세요.");

        return makeMoney(Integer.parseInt(money));
    }

    public int getPossibleLottoCount(){
        return money / LOTTO_PRICE;
    }

    public void buyLottos(int quantityOfLotto){
        if(quantityOfLotto * LOTTO_PRICE > money)
            throw new IllegalArgumentException("소지금보다 많습니다.");

        money -= quantityOfLotto * LOTTO_PRICE;
    }
}
