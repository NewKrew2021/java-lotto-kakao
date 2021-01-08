package lotto;

import lotto.domain.game.LottoGameCount;
import lotto.domain.game.LottoRevenue;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.NumberGenerateStrategy;
import lotto.domain.number.RandomGenerateStrategy;
import lotto.domain.ranking.LottoRankingCount;
import lotto.domain.game.WinnerTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int inputMoney = 14000;
        LottoGameCount lottoGameCount = new LottoGameCount(inputMoney);
        NumberGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
        List<LottoNumbers> lottoTickets = new ArrayList<>();

        while (lottoGameCount.isTicketRemain()) {
            lottoTickets.add(LottoNumbers.from(randomGenerateStrategy));
            lottoGameCount.useTicket();
        }

        int bonusNumber = 7;
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinnerTicket winnerTicket = WinnerTicket.of(winnerNumbers, bonusNumber);

        LottoRankingCount lottoRankingCount = LottoRankingCount.of(lottoTickets, winnerTicket);

        double lottoRevenueRate = LottoRevenue.from(lottoRankingCount).calculateRevenueRate(lottoGameCount);
    }
}