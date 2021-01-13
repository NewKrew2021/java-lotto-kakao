package lotto.domain;

import lotto.utils.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    public static final int NUMBER = 6;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(String[] textLottos) {
        lottos = new ArrayList<>();
        for (String textLotto : textLottos) {
            lottos.add(Lotto.of(textLotto));
        }
    }

    public static Lottos getAutoLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < number; ++i) {
            lottos.add(Lotto.of(RandomNo.generateRandomNos(NUMBER)));
        }

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResults allCompare(WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(winningLotto.compare(lotto));
        }
        return new LottoResults(results);
    }

    public Lottos merge(Lottos lottos) {
        List<Lotto> newLottos = new ArrayList<>(this.lottos);
        newLottos.addAll(lottos.getLottos());
        return new Lottos(newLottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
