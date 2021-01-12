package lotto.controller;

import lotto.domain.game.LottoGameCount;
import lotto.domain.game.LottoRevenue;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.domain.ranking.LottoRankingCount;
import lotto.view.LottoRankingCountDto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private List<LottoNumbers> lottoTickets = new ArrayList<>();
    private LottoGameCount lottoGameCount;
    private WinnerTicket winnerTicket;
    private LottoRankingCount lottoRankingCount;

    public LottoController(int inputMoney, int numOfManualNumbers) {
        this.lottoGameCount = new LottoGameCount(inputMoney, numOfManualNumbers);
    }

    public void makeTicketByStrategy(NumberGenerateStrategy numberGenerateStrategy) {
        LottoNumbers lottoTicket = LottoNumbers.from(numberGenerateStrategy);
        lottoTickets.add(lottoTicket);
        lottoGameCount.useTicket();
    }

    public void setWinnerTicket(List<Integer> winnerNumbers, int bonusNumber) {
        winnerTicket = WinnerTicket.of(winnerNumbers, bonusNumber);
    }

    public boolean isTicketRemain() {
        return lottoGameCount.isTicketRemain();
    }

    public boolean isManualTicketRemain() {
        return lottoGameCount.isManualTicketRemain();
    }

    public LottoRankingCountDto getRankingCountDto() {
        lottoRankingCount = LottoRankingCount.of(lottoTickets, winnerTicket);
        return LottoRankingCountDto.from(lottoRankingCount);
    }

    public double getLottoRevenueRate() {
        return LottoRevenue.of(lottoRankingCount, lottoGameCount).calculateRevenueRate();
    }

    public int getNumOfAutoTickets() {
        return lottoGameCount.getAutoTicketCount();
    }

    public int getNumOfAllTickets() {
        return lottoGameCount.getTicketCount();
    }

    public int getNumOfManualTickets() {
        return lottoGameCount.getManualTicketCount();
    }

    public List<Integer> getSortedLottoNumbers(int i) {
        return lottoTickets.get(i).getSortedLottoNumbersAsInteger();
    }

}
