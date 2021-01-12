package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void addRandomLotto() {
        lottos.add(Lotto.generateRandomLotto());
    }

    public void addManualLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<LottoResult> checkLottos(Lotto winningLotto, LottoNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.checkLotto(winningLotto, bonusNumber))
                .collect(Collectors.toList());
    }
}
