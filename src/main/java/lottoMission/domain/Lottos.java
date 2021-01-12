package lottomission.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        Collections.sort(this.lottos);
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public List<List<Integer>> getLottosNumberList() {
        return lottos
                .stream()
                .map(Lotto::getLottoNumberList)
                .collect(Collectors.toList());
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
