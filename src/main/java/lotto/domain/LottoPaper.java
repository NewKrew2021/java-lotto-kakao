package lotto.domain;

import lotto.dto.LottoNumberData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPaper {
    private List<Ticket> tickets;

    public static LottoPaper join(LottoPaper paper1, LottoPaper paper2){
        List<Set<Integer>> data = paper1.getLottoNumberData().getNumberData();
        for(Set<Integer> oneLine : paper2.getLottoNumberData().getNumberData()){
            data.add(new HashSet<>(oneLine));
        }
        return new LottoPaper(new ManuallyGeneratingStrategy(data));
    }

    public LottoPaper(GeneratingStrategy strategy) {
        tickets = Stream.generate(() -> new Ticket(strategy))
                .limit(strategy.getLimit())
                .collect(Collectors.toList());
    }

    /* 로또 숫자 정보가 수정되는 것을 막기 위해 정보를 복사하여 전달한다. */
    public LottoNumberData getLottoNumberData() {
        List<Set<Integer>> responseData = new ArrayList<>();

        for(Ticket ticket : tickets){
            responseData.add(ticket.getNumberData());
        }

        return new LottoNumberData(responseData);
    }

    /* 당첨정보를 받아서 이 객체와 비교후, 결과정보를 반환한다. */
    public LottoResult getResultCompareWith(WinnerBalls winnerBalls) {
        LottoResult lottoResult = new LottoResult();
        for(Ticket curTicket : tickets){
            Rank rankOfCurTicket = winnerBalls.getRankOf(curTicket);
            lottoResult.putRank(rankOfCurTicket);
        }
        return lottoResult;
    }
}
