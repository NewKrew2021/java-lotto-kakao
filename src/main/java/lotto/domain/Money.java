package lotto.domain;

public class Money {

    private int money = 0;

    public Money(String money) {
        if( !checkValidationInputMoney(money) ) {
            throw new IllegalArgumentException();
        }
        this.money = Integer.parseInt(money);
    }

    public static boolean checkValidationInputMoney(String money) {

        if (!money.matches("[0-9]+")) {
            return false;
        }

        if ( Integer.parseInt(money) < LottoTicket.LOTTO_PRICE ) {
            return false;
        }

        return true;
    }



}
