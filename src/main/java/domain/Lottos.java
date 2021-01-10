package domain;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(PurchaseInfo purchaseInfo) {
        lottos = new ArrayList<>();
        for (long lottoCount = 0; lottoCount < purchaseInfo.getPurchaseCount(); lottoCount++) {
            lottos.add(new Lotto(new RandomLottoStrategy().numberChooseStrategy()));
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoStatus, Integer> checkResult(Answer answer) {
        Map<LottoStatus, Integer> result = new HashMap<>();
        LottoStatus.getLottoStatuses().stream().forEach(lottoStatus -> { result.put(lottoStatus, 0); });

        lottos.stream().forEach(lotto -> { addResult(result, lotto.getResult(answer)); });
        return result;
    }

    private void addResult(Map<LottoStatus, Integer> result, LottoStatus lottoStatus) {
        if (lottoStatus != lottoStatus.NONE) {
            result.put(lottoStatus, result.get(lottoStatus) + 1);
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Lotto lotto : lottos) {
            stringBuffer.append(lotto + "\n");
        }
        return stringBuffer.toString();
    }
}
