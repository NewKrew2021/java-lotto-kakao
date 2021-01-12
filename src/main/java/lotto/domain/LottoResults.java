package lotto.domain;

import lotto.utils.Result;
import java.util.List;

public class LottoResults {
    private final List<Result> lottoResults;

    public LottoResults(List<Result> results) {
        lottoResults = results;
    }

    public static Result mapResult(int count, boolean bonus) {
        if (count < 3) return Result.UNDERTHREE;
        if (count == 5 && bonus) return Result.BONUSFIVE;
        return Result.values()[count - 2];
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
