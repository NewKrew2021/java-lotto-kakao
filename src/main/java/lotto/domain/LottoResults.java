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

    @Override
    public String toString() {
        return "3개 일치 (" + Result.THREE.getReward() + "원)- " + getResultCount(Result.THREE) + "개\n" +
                "4개 일치 (" + Result.FOUR.getReward() + "원)- " + getResultCount(Result.FOUR) + "개\n" +
                "5개 일치 (" + Result.FIVE.getReward() + "원)- " + getResultCount(Result.FIVE) + "개\n" +
                "5개 일치, 보너스 볼 일치(" + Result.BONUSFIVE.getReward() + "원)- " + getResultCount(Result.BONUSFIVE) + "개\n" +
                "6개 일치 (" + Result.SIX.getReward() + "원)- " + getResultCount(Result.SIX) + "개";
    }
}
