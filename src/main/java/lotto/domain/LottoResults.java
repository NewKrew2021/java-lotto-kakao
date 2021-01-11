package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private static LottoResults lottoResults;
    private static final Map<LottoRank, Integer> results;
    static {
        results = new HashMap<LottoRank, Integer>() {{
            for (LottoRank rank : LottoRank.values()) {
                put(rank, 0);
            }
        }};
    }

    private LottoResults(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        lottoTickets.stream()
                .filter(lottoTicket -> lottoTicket.matchCount(winningNumber) >= 3)
                .forEach(lottoTicket -> {
                    LottoRank rank = RankTable.get(lottoTicket.matchCount(winningNumber),
                            lottoTicket.contains(winningNumber.getBonusNumber()));
                    results.put(rank, results.get(rank)+1);
                });
    }

    public static LottoResults createLottoResults(List<LottoTicket> lottoTickets, WinningNumber winningNumber){
        lottoResults = new LottoResults(lottoTickets, winningNumber);
        return lottoResults;
    }

    public Map<LottoRank, Integer> getLottoResults(){
        return lottoResults.getResults();
    }

    private Map<LottoRank, Integer> getResults(){
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(results, that.results);
    }


}
