package lotto.domain;

import lotto.exception.FailBuyLottoException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<List<Integer>> lottos, int randomLottoCount) {
        if (randomLottoCount < 0) {
            throw new FailBuyLottoException();
        }
        this.lottos = lottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
        this.lottos.addAll(IntStream.range(0, randomLottoCount)
                .mapToObj(num -> new Lotto())
                .collect(Collectors.toList()));
    }

    public Rankings raffle(WinningLotto winningNumber) {
        return new Rankings(lottos, winningNumber);
    }

    public List<Set<LottoNumber>> getLottosData() {
        return lottos.stream()
                .map(Lotto::getLottoData)
                .collect(Collectors.toList());
    }


}
