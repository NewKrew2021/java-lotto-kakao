package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final int LOTTO_NUMBER_COUNT = 6;
    private List<Lotto> lottos;


    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<LottoRank> lottosResult(WonLotto wonLotto) {

        List<LottoRank> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(wonLotto.checkRanking(lotto));
        }
        return results;
    }

    public List<Integer> lottosRankingResult(List<LottoRank> lottoRank) {
        int[] rankingResult = new int[LOTTO_NUMBER_COUNT];
        Arrays.fill(rankingResult, 0);

        for (LottoRank rank : lottoRank) {
            rankingResult[rank.getIndex()]++;
        }

        return Arrays.stream(rankingResult).boxed().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Lotto lotto : lottos) {
            str.append(lotto.toString());
        }
        return str.toString();
    }
}
