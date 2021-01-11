package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int totalCount) {
        lottos = new ArrayList<>();
        for (int count = 0; count < totalCount; count++) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public List<Lotto> getLottos() {
        return lottos;
    }
}
