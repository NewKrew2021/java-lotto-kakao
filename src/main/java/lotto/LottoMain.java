package lotto;

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

        //inputMoney를 없애는게 좋을 것 같음. Rate를 Revenue안으로 넣는다.
        long lottoRevenue = new LottoRevenue(lottoRankingCount.getRankingCount()).getRevenue();
        double lottoRevenueRate = ((double) (lottoRevenue - inputMoney) / inputMoney) * 100.0;

    }
}