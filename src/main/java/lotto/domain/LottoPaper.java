package lotto.domain;

import lotto.dto.LottoNumberData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPaper {
    private List<Ticket> tickets;

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
            int matchCount = winnerBalls.getMatchCountComparedWith(curTicket);
            boolean matchBonusBall = curTicket.isContain(winnerBalls.getBonusBall());
            lottoResult.putRank(Rank.getRankAccordingTo(matchCount, matchBonusBall));
        }
        return lottoResult;
    }
}
