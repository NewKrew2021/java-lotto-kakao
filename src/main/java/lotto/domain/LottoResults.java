package lotto.domain;

import lotto.utils.Result;

import java.util.Arrays;
import java.util.List;

public class LottoResults {
    private final List<Result> lottoResults;

    public LottoResults(List<Result> results) {
        lottoResults = results;
    }

    public static Result mapResult(int match, boolean bonus) {
        if (match <= Result.UNDERTHREE.getMatch()) return Result.UNDERTHREE;
        if (match == Result.BONUSFIVE.getMatch() && bonus) return Result.BONUSFIVE;
        return Arrays.stream(Result.values())
                .filter(result -> result.getMatch() == match)
                .findFirst()
                .orElse(null);
    }

    public int getResultCount(Result result) {
        return (int) lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(result))
                .count();
    }

    public long getReward() {
        return lottoResults.stream()
                .mapToLong(Result::getReward)
                .sum();
    }

}
