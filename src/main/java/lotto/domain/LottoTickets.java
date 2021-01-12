package lotto.domain;

import java.util.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets){
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoResults getResults(WinningNumber winningNumber) {
        LottoResults lottoResults = CreateLottoResults.createLottoResults(lottoTickets, winningNumber);
        return lottoResults;
    }
}
