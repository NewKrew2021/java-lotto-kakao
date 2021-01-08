package lotto.domain;

/*
 * //TODO 클래스 설명같은거 이곳에 있으면 좋겠다. 형식 맞춰서 말이다.
 */

import lotto.dto.LottoNumberData;

import java.util.*;

public class LottoPaper {

    private final static int[] PRIZE = new int[]{0, 2000000000, 30000000, 1500000, 50000, 5000, 0}; //TODO : 뭔가 조치가 필요해 보인다.
    private List<Ticket> tickets;

    public LottoPaper(LottoNumberData lottoNumberData){ //TODO: 들어온 데이터가 유효한지 판단해주어야 한다.
        tickets = new ArrayList<>();

        for (Set<Integer> currentTicketData : lottoNumberData.getNumberData()) {
            tickets.add(new Ticket(currentTicketData));
        }
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
