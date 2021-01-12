package mission.lotto.domain;

import mission.lotto.util.Random;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        Collections.sort(this.lottos);
    }

    public static Lottos buyLottos(int manualCount, List<List<Integer>> manualInput, UserMoney userMoney) {
        int totalQuantity = lottoAmount(userMoney);
        Stream<Lotto> manualLottos = IntStream.range(0, manualCount)
                .mapToObj(value -> new Lotto(manualInput.get(value)));
        Stream<Lotto> autoLottos = IntStream.range(0, totalQuantity - manualCount)
                .mapToObj(value -> new Lotto(Random.getSixNumbers()));
        return new Lottos(Stream.concat(manualLottos, autoLottos)
                .collect(Collectors.toList()));
    }

    private static int lottoAmount(UserMoney userMoney) {
        return userMoney.getUserMoney() / Lotto.LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
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
