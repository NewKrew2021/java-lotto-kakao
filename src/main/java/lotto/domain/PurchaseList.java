package lotto.domain;

import java.util.List;
import java.util.Set;

public class PurchaseList {

    private int autoTicketCount;
    private int manualTicketCount;
    private List<Set<Integer>> manualLottoTicketNumbers;

    public PurchaseList(int money) {
        if( !validateInputMoney(money) ) {
            throw new IllegalArgumentException("잘못된 금액을 입력하셨습니다.");
        }

        this.autoTicketCount = money / 1000;
    }

    public PurchaseList(int money, List<Set<Integer>> manualLottoTicketNumbers) {
        if( !validateInputMoney(money) ) {
            throw new IllegalArgumentException("잘못된 금액을 입력하셨습니다.");
        }

        this.manualTicketCount = manualLottoTicketNumbers.size();
        this.autoTicketCount = money / 1000 - manualTicketCount;
        this.manualLottoTicketNumbers = manualLottoTicketNumbers;
    }

    public static boolean validateInputMoney(final int money) {
        return money >= LottoTicket.LOTTO_PRICE;
    }

    public boolean payForAutoTicketing() {
        if( this.autoTicketCount <= 0 ) {
            return false;
        }
        this.autoTicketCount -= 1;
        return true;
    }

    public boolean payForManualTicketing() {
        if( this.manualTicketCount <= 0 ) {
            return false;
        }
        this.manualTicketCount -= 1;
        return true;
    }

    public Set<Integer> getManualTicketNumbers() {
        return this.manualLottoTicketNumbers.get(this.manualTicketCount);
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

}
