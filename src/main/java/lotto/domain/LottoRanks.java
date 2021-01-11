package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRanks {

    private final int LOTTO_PRICE = 1000;
    private final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {

        this.lottoRanks = lottoRanks;
    }

    private int totalPrize() {

        int sum = 0;
        for (LottoRank lottoRank : lottoRanks) {
            sum += lottoRank.getMoney();
        }
        return sum;
    }

    public double profitRatio() {

        double ratio = (double) totalPrize() / (double) (lottoRanks.size() * LOTTO_PRICE);
        return ratio;
    }

    private List<Integer> rankStatistics() {

        int[] rankingResult = new int[LOTTO_NUMBER_COUNT];
        Arrays.fill(rankingResult, 0);

        for (LottoRank rank : lottoRanks) {
            rankingResult[rank.getIndex()]++;
        }

        return Arrays.stream(rankingResult).boxed().collect(Collectors.toList());
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> rankInfo = rankStatistics();
        for (int i = 4; i >= 0; i--) {
            stringBuilder.append(LottoRank.values()[i].getMatchedPhrase());
            stringBuilder.append("(");
            stringBuilder.append(LottoRank.values()[i].getMoney());
            stringBuilder.append("원)-");
            stringBuilder.append(rankInfo.get(i));
            stringBuilder.append("개\n");
        }
        return stringBuilder.toString();
    }
}
