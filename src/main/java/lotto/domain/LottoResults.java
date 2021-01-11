package lotto.domain;

import com.sun.org.apache.xml.internal.utils.res.XResources_zh_TW;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private static Map<LottoRank, Integer> results;

    private LottoResults(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        results = new HashMap<LottoRank, Integer>();
        lottoTickets.stream()
                .forEach(lottoTicket -> {
                    LottoRank rank = LottoRank.getRank(lottoTicket.matchCount(winningNumber),
                            winningNumber.bonusNumberContain(lottoTicket));
                    results.putIfAbsent(rank, 0);
                    results.put(rank, results.get(rank)+1);
                });
        for (LottoRank rank : LottoRank.values()) {
        }
    }

    public static LottoResults createLottoResults(List<LottoTicket> lottoTickets, WinningNumber winningNumber){
        return new LottoResults(lottoTickets, winningNumber);
    }

    public int getCountLottoRank(LottoRank rank){
        if (results.get(rank) != null){
            return results.get(rank);
        }
        return 0;
    }

    public long earningRate(int price) {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += getCountLottoRank(rank) * rank.getPrice();
        }
        return (long) (sum / price * 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(results, that.results);
    }


}
