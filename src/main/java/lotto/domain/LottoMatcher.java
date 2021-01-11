package lotto.domain;

public class LottoMatcher {
    private final WinningNumbers winningNumbers;

    public LottoMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public MatchResults match(LottoTickets lottoTickets) {
        return winningNumbers.matchLotto(lottoTickets);
    }

    public MatchResult match(LottoNumbers lottoTicket) {
        return winningNumbers.matchLotto(lottoTicket);
    }
}
