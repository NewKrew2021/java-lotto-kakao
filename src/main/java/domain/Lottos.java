package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int totalCount){
        lottos = new ArrayList<>();
        for(int count = 0; count < totalCount; count++){
            lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public BigDecimal calculateNumberOfRank(LottoRank lottoRank, Lotto winningLotto) {
        return new BigDecimal(
                String.valueOf(
                        lottos.stream()
                                .filter(lotto -> lottoRank.checkRank(lotto, winningLotto))
                                .count()));
    }

    public LottoStatistics getLottoStatistics(Lotto winningLotto,int lottoCount) {
        HashMap<LottoRank, BigDecimal> rankNumbers = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            rankNumbers.put(lottoRank, calculateNumberOfRank(lottoRank, winningLotto));
        }

        return new LottoStatistics(rankNumbers,lottoCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
