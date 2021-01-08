package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private LottoNumber lottoNumber;

    public LottoTickets(int price) {
        lottoNumber = new LottoNumber();
        lottoTickets = new ArrayList<>();
        lottoTickets = IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(lottoNumber.getRandomNumbers())))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoResults getResults(WinningNumber winningNumber) {
        LottoResults lottoResults = new LottoResults();
        lottoTickets.stream()
                .filter(lottoTicket -> lottoTicket.getRank(winningNumber) != null)
                .forEach(lottoTicket -> lottoResults.upsert(lottoTicket.getRank(winningNumber)));
        return lottoResults;
    }
}
