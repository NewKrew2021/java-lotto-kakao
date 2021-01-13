package lotto.domain;

public class Money {

    private int money;

    public Money(int money) {
        if( !validateInputMoney(money) ) {
            throw new IllegalArgumentException("잘못된 금액을 입력하셨습니다.");
        }
        this.money = money;
    }

    public static boolean validateInputMoney(final int money) {
        return money >= LottoTicket.LOTTO_PRICE;
    }

    public boolean payForAutoTicketing() {
        if( this.money < LottoTicket.LOTTO_PRICE) {
            return false;
        }
        this.money -= LottoTicket.LOTTO_PRICE;
        return true;
    }
}
