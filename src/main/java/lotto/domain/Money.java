package lotto.domain;

public class Money {

    private int money;

    public Money(int money) {
        if( !checkValidationInputMoney(money) ) {
            IllegalArgumentException error = new IllegalArgumentException();
            error.printStackTrace();
            throw error;
        }
        this.money = money;
    }

    public static boolean checkValidationInputMoney(int money) {
        return money >= LottoTicket.LOTTO_PRICE;
    }

    public boolean payForTicket() {
        if( this.money < LottoTicket.LOTTO_PRICE) {
            return false;
        }
        this.money -= LottoTicket.LOTTO_PRICE;
        return true;
    }
}
