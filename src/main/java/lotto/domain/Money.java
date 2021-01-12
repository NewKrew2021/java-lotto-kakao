package lotto.domain;

public class Money {

    private int money = 0;

    public Money(int money) {
        if( !checkValidationInputMoney(money) ) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public static boolean checkValidationInputMoney(int money) {

        if ( money < LottoTicket.LOTTO_PRICE ) {
            return false;
        }

        return true;
    }

    public boolean payForTicket() {
        if( this.money < LottoTicket.LOTTO_PRICE) {
            return false;
        }
        this.money -= LottoTicket.LOTTO_PRICE;
        return true;
    }
}
