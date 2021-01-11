package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public void addRandomLottos(int numberOfLottos){
        for (int i = 0; i < numberOfLottos; i++) {
            addLotto(Lotto.generateRandomLotto());
        }
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
