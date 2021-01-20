package lotto.domain;

import java.util.List;
import java.util.Set;

public class BuyingListDto {

    private int money;
    private int manualTicketCount;
    private List<Set<Integer>> manualLottoNumbers;
    private BuyingList buyingList;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public void setManualTicketCount(int manualTicketCount) {
        this.manualTicketCount = manualTicketCount;
    }

    public List<Set<Integer>> getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public void setManualLottoNumbers(List<Set<Integer>> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public BuyingList getBuyingList() {
        return buyingList;
    }

    public void setBuyingList(BuyingList buyingList) {
        this.buyingList = buyingList;
    }
}
