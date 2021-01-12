package lotto.domain;

import lotto.util.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static Lottos of(List<Lotto> manualLottoList, List<Lotto> autoLottoList) {
        return new Lottos(Stream.concat(manualLottoList.stream(), autoLottoList.stream())
                .collect(Collectors.toList()));
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
