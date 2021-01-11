package lotto.domain;

import java.util.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private LottoNumber lottoNumber;

    public LottoTickets(List<LottoTicket> makeLottoTickets){
        lottoTickets = makeLottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public Map<LottoRank, Integer> getResults(WinningNumber winningNumber) {
        LottoResults lottoResults = LottoResults.createLottoResults(lottoTickets, winningNumber);

        return lottoResults.getLottoResults();
    }
}
