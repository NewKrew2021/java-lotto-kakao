package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;


    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;

    }

    public Lottos() {
        this.lottos=new ArrayList<>();
    }

    public void add(Lotto lotto){
        lottos.add(lotto);
    }

    public List<LottoRank> lottosResult(WonLotto wonLotto){

        List<LottoRank> results=new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(wonLotto.checkRanking(lotto));
        }
        return results;
    }

}
