package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.util.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Rank> match(MatchNumber matchNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(matchNumber))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
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
