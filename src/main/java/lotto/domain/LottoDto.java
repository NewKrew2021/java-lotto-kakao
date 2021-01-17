package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoDto {

    private PurchaseList purchaseList;
    private List<LottoTicket> lottoTickets;
    private WinningLottoNos winningLottoNos;
    private StatisticsResult statisticsResult;
    private int money;
    private int manualTicketCount;
    private List<Set<Integer>> manualLottoNumbers;
    private Set<Integer> winningLottoOnlyNumbers;
    private int bonusNumber;

    public Set<Integer> getWinningLottoOnlyNumbers() {
        return winningLottoOnlyNumbers;
    }

    public void setWinningLottoOnlyNumbers(Set<Integer> winningLottoOnlyNumbers) {
        this.winningLottoOnlyNumbers = winningLottoOnlyNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public PurchaseList getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(PurchaseList purchaseList) {
        this.purchaseList = purchaseList;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void setLottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public WinningLottoNos getWinningLottoNos() {
        return winningLottoNos;
    }

    public void setWinningLottoNos(WinningLottoNos winningLottoNos) {
        this.winningLottoNos = winningLottoNos;
    }

    public StatisticsResult getStatisticsResult() {
        return statisticsResult;
    }

    public void setStatisticsResult(StatisticsResult statisticsResult) {
        this.statisticsResult = statisticsResult;
    }

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
}
