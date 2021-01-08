package lotto.domain;

/*
 * //TODO 클래스 설명같은거 이곳에 있으면 좋겠다. 형식 맞춰서 말이다.
 */

import lotto.dto.LottoNumberData;

import java.util.*;

public class LottoPaper {

    private final static int[] PRIZE = new int[]{0, 2000000000, 30000000, 1500000, 50000, 5000, 0}; //TODO : 뭔가 조치가 필요해 보인다.
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

    public long getScoreCompareWith(WinnerBalls winnerBalls) {
        List<Integer> orders = getOrdersCompareWith(winnerBalls);

        long money = 0;
        for (Integer order : orders) {
            money += PRIZE[order];
        }

        return money;
    }

    private List<Integer> getOrdersCompareWith(WinnerBalls winnerBalls){
        List<Integer> orders = new ArrayList<>();

        for(Ticket curTicket : tickets){
            int order = curTicket.getOrder(winnerBalls);
            orders.add(order);
        }

        return orders;
    }
}
