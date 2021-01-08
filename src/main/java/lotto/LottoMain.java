package lotto;

import java.util.*;

public class LottoMain {
    public static void main(String[] args) {
        int inputMoney = 14000;
        LottoGameCount lottoGameCount = new LottoGameCount(inputMoney);
        NumberGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();
        List<LottoNumbers> lottoTickets = new ArrayList<>();
        // while(isend) 로 바꿀만 하다.
        for (int i = 0; i < lottoGameCount.getTicketNumber(); i++) {
            lottoTickets.add(LottoNumbers.from(randomGenerateStrategy));
        }

        int bonusNumber = 7;
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        NumberGenerateStrategy manualInputStrategy = new ManualInputStrategy(winnerNumbers);
        //리스트랑 보너스번호만 받아서 위너 티켓을 만드는 방법.
        WinnerTicket winnerTicket = new WinnerTicket(LottoNumbers.from(manualInputStrategy),
                new LottoNumber(bonusNumber));

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