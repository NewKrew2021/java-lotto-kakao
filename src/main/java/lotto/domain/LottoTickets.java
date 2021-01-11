package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private LottoNumber lottoNumber;

    public LottoTickets(List<LottoTicket> makeLottoTickets){
        lottoTickets = makeLottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoResults getResults(WinningNumber winningNumber) {
        LottoResults lottoResults = new LottoResults();
        lottoTickets.stream()
                .filter(lottoTicket -> lottoTicket.matchCount(winningNumber) >= 3)
                .forEach(lottoTicket -> {
                    lottoResults.upsert(RankTable.get(lottoTicket.matchCount(winningNumber),
                            lottoTicket.contains(winningNumber.getBonusNumber())));
                });
        return lottoResults;
    }
}
