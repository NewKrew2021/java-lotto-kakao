package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final WinningNumbers winningNumbers;

    public LottoMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public MatchResults match(LottoTickets lottoTickets) {
        List<MatchResult> results = lottoTickets.getTickets()
                .stream()
                .map(this::match)
                .collect(Collectors.toList());
        return new MatchResults(results);
    }

    public MatchResult match(LottoNumbers lottoTicket) {
        int matchCount = calcMatchCount(lottoTicket);
        boolean matchBonus = isMatchBonus(lottoTicket);
        return MatchResult.valueOf(matchCount, matchBonus);
    }

    private int calcMatchCount(LottoNumbers lottoTicket) {
        LottoNumbers luckyNumbers = winningNumbers.getLuckyNumbers();

        return (int) luckyNumbers.toStream()
                .filter(lottoTicket::contains)
                .count();
    }

    private boolean isMatchBonus(LottoNumbers lottoTicket) {
        LottoNumber bonusNumber = winningNumbers.getBunusNumber();
        return lottoTicket.contains(bonusNumber);
    }
}
