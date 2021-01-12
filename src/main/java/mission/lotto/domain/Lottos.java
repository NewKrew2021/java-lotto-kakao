package mission.lotto.domain;

import mission.lotto.util.Random;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buyLottos(int manualCount, List<List<Integer>> manualInput, UserMoney userMoney) throws LottoException {
        int totalQuantity = lottoAmount(userMoney);
        if (manualCount > totalQuantity) {
            throw new LottoException("구입금액보다 많은 수의 수동 구매는 불가합니다.");
        }

        Stream<Lotto> manualLottos = IntStream.range(0, manualCount)
                .mapToObj(value -> new Lotto(manualInput.get(value)));
        Stream<Lotto> autoLottos = IntStream.range(0, totalQuantity - manualCount)
                .mapToObj(value -> new Lotto(Random.getSixNumbers()));

        return new Lottos(Stream.concat(manualLottos, autoLottos)
                .sorted()
                .collect(Collectors.toList()));
    }

    private static int lottoAmount(UserMoney userMoney) {
        return userMoney.getUserMoney() / Lotto.LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
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
