package lotto.domain;

import lotto.dto.RankingsDto;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public int getNumOfLotto() {
        return lottos.size();
    }

    public RankingsDto match(MatchNumber matchNumber) {
        RankingsDto rankingsDto = new RankingsDto();
        for (Lotto lotto : lottos) {
            rankingsDto.addRank(lotto.match(matchNumber));
        }
        return rankingsDto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append("\n");
        }
        return sb.toString();
    }
}
