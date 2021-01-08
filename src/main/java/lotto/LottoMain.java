package lotto;

import java.util.*;

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

        //안쪽에서 만드는것이 좋을 것으로 생각.
        Map<LottoRanking, Integer> rankingCount = new HashMap<>();

        for (LottoNumbers lottoTicket : lottoTickets) {
            LottoRanking ranking = LottoRanking.find(winnerTicket.countMatchingNumber(lottoTicket),
                    winnerTicket.hasBonus(lottoTicket));
            rankingCount.compute(ranking, (rank, count) -> count == null ? 1 : count + 1);
        }

        //inputMoney를 없애는게 좋을 것 같음. Rate를 Revenue안으로 넣
        long lottoRevenue = new LottoRevenue(rankingCount).getRevenue();
        double lottoRevenueRate = ((double) (lottoRevenue - inputMoney) / inputMoney) * 100.0;

    }
}