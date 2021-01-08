package lotto.domain;

import lotto.domain.dto.LottoNumber;
import lotto.domain.dto.WinningNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final WinningNumbers winningNumbers;

    public LottoMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public MatchResults match(LottoTickets lottoTickets) {
        List<MatchResult> results = new ArrayList<>();

        lottoTickets.delegate(tickets -> results.addAll(tickets.stream()
                .map(this::match)
                .collect(Collectors.toList())));

        return new MatchResults(results);
    }

    public MatchResult match(LottoNumbers lottoTicket) {
        int matchCount = calcMatchCount(lottoTicket);
        boolean matchBonus = isMatchBonus(lottoTicket);
        return MatchResult.valueOf(matchCount, matchBonus);
    }

    private int calcMatchCount(LottoNumbers lottoTicket) {
        int[] count = new int[1];
        LottoNumbers luckyNumbers = winningNumbers.getLuckyNumbers();

        luckyNumbers.delegate(lottoNumbers ->
                count[0] = (int) lottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count());

        return count[0];
    }

    private boolean isMatchBonus(LottoNumbers lottoTicket) {
        LottoNumber bonusNumber = winningNumbers.getBonusNumber();
        return lottoTicket.contains(bonusNumber);
    }
}
