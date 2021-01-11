package lotto.domain;

import lotto.domain.vo.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final LottoNumbers luckyNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        if (isDuplicate(luckyNumbers, bonusNumber)) {
            throw new IllegalArgumentException("Bonus number already exists in lucky numbers");
        }

        this.luckyNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;
    }

    public MatchResults matchLotto(LottoTickets lottoTickets) {
        List<MatchResult> results = new ArrayList<>();
        List<Integer> calcMatchCounts = lottoTickets.getMatchCountsInOrder(luckyNumbers);
        List<Boolean> areMatchBonuses = lottoTickets.getContainsBonusNumberInOrder(bonusNumber);

        for (int i = 0; i < calcMatchCounts.size(); i++) {
            results.add(MatchResult.valueOf(calcMatchCounts.get(i), areMatchBonuses.get(i)));
        }

        return new MatchResults(results);
    }

    public MatchResult matchLotto(LottoNumbers lottoTicket) {
        int matchCount = lottoTicket.getMatchCount(luckyNumbers);
        boolean isMatchBonus = lottoTicket.isMatchBonus(bonusNumber);

        return MatchResult.valueOf(matchCount, isMatchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return this.luckyNumbers.equals(that.luckyNumbers)
                && this.bonusNumber.equals(that.bonusNumber);
    }

    private boolean isDuplicate(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        return luckyNumbers.contains(bonusNumber);
    }
}
