package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateLottoResults {
    public static LottoResults createLottoResults(List<LottoTicket> lottoTickets, WinningNumber winningNumber){
        Map<LottoRank, Integer> results = new HashMap<LottoRank, Integer>();
        lottoTickets.stream()
                .forEach(lottoTicket -> {
                    LottoRank rank = LottoRank.getRank(lottoTicket.matchCount(winningNumber),
                            winningNumber.bonusNumberContain(lottoTicket));
                    results.putIfAbsent(rank, 0);
                    results.put(rank, results.get(rank)+1);
                });
        return new LottoResults(results);
    }
}
