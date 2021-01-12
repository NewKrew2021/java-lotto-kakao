package lotto.controller;

import lotto.domain.game.LottoGameCount;
import lotto.domain.game.LottoRevenue;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.domain.ranking.LottoRankingCount;
import lotto.view.LottoNumbersDto;
import lotto.view.LottoRankingCountDto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private NumberGenerateStrategy numberGenerateStrategy;
    private List<LottoNumbers> lottoTickets = new ArrayList<>();
    private LottoGameCount lottoGameCount;
    private WinnerTicket winnerTicket;
    private LottoRankingCount lottoRankingCount;

    private LottoController(NumberGenerateStrategy numberGenerateStrategy, int inputMoney) {
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.lottoGameCount = new LottoGameCount(inputMoney);
    }

    public static LottoController of(NumberGenerateStrategy numberGenerateStrategy, int lottoGameCount) {
        return new LottoController(numberGenerateStrategy, lottoGameCount);
    }

    public LottoNumbersDto gamePlay() {
        LottoNumbers lottoTicket = LottoNumbers.from(numberGenerateStrategy);
        lottoTickets.add(lottoTicket);
        lottoGameCount.useTicket();
        return LottoNumbersDto.from(lottoTicket);
    }

    public void setWinnerTicket(List<Integer> winnerNumbers, int bonusNumber) {
        winnerTicket = WinnerTicket.of(winnerNumbers, bonusNumber);
    }

    public boolean isTicketRemain() {
        return lottoGameCount.isTicketRemain();
    }

    public LottoRankingCountDto getRankingCountDto() {
        lottoRankingCount = LottoRankingCount.of(lottoTickets, winnerTicket);
        return LottoRankingCountDto.from(lottoRankingCount);
    }

    public double getLottoRevenueRate() {
        return LottoRevenue.of(lottoRankingCount, lottoGameCount).calculateRevenueRate();
    }

}
