package lotto.domain;

import lotto.dto.LottoNumberData;
import lotto.dto.LottoResult;
import lotto.setting.Rank;

import java.util.*;

public class LottoPaper {

    private List<Ticket> tickets;

    public LottoPaper(LottoNumberData request){
        tickets = new ArrayList<>();

        for (Set<Integer> currentTicketData : request.getNumberData()) {
            tickets.add(new Ticket(currentTicketData));
        }
    }

    /* 로또 숫자 정보가 수정되는 것을 막기 위해 정보를 복사하여 전달한다. */
    public LottoNumberData getLottoNumberData(){
        List<Set<Integer>> responseData = new ArrayList<>();

        for(Ticket ticket : tickets){
            responseData.add(ticket.getNumberData());
        }

        return new LottoNumberData(responseData);
    }

    public LottoResult getResultCompareWith(WinnerBalls winnerBalls){
        long score = getScoreCompareWith(winnerBalls);
        List<Rank> countList = getOrdersCompareWith(winnerBalls);
        return new LottoResult(score, countList);
    }

    public long getScoreCompareWith(WinnerBalls winnerBalls) {
        List<Rank> orders = getOrdersCompareWith(winnerBalls);

        long money = 0;
        for (Rank order : orders) {
            money += order.getPrize();
        }

        return money;
    }

    private List<Rank> getOrdersCompareWith(WinnerBalls winnerBalls){
        List<Rank> orders = new ArrayList<>();

        for(Ticket curTicket : tickets){
            Rank order = curTicket.getOrder(winnerBalls);
            orders.add(order);
        }

        return orders;
    }
}
