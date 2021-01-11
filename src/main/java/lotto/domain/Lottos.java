package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;


    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;

    }

    public Lottos() {
        this.lottos=new ArrayList<>();
    }

    public List<Lotto> getLottos(){
        final List<Lotto> lottos = new ArrayList<>(this.lottos);
        return lottos;
    }

    public void add(Lotto lotto){
        lottos.add(lotto);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        lottos.forEach(lotto -> str.append(lotto.toString()));
        return str.toString();
    }
}
