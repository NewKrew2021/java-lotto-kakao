package lotto.domain;

import lotto.dto.RankingsDto;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static Lottos fromMoney(Money money, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money.howMany(); i++) {
            lottoList.add(new Lotto(lottoNumberGenerator));
        }
        return new Lottos(lottoList);
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
