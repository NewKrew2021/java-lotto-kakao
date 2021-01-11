package lotto.domain;

import java.util.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> makeLottoTickets){
        lottoTickets = makeLottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoResults getResults(WinningNumber winningNumber) {
        LottoResults lottoResults = LottoResults.createLottoResults(lottoTickets, winningNumber);
        return lottoResults;
    }
}
