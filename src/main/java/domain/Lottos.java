package domain;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottos;
    private final PurchaseInfo purchaseInfo;

    public Lottos(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.purchaseInfo = new PurchaseInfo(PurchaseInfo.LOTTE_PRICE * lottos.size(), lottos.size());
    }

    public void buyLotto(LottoStrategy lottoStrategy) {
        lottos.add(new Lotto(lottoStrategy));
        purchaseInfo.buyLotto();
    }

    public boolean buyAllSelfLottos() {
        return purchaseInfo.buyAllSelfLottos();
    }

    public boolean buyAllAutoLottos() {
        return purchaseInfo.buyAllAutoLottos();
    }

    public long getTotalPurchaseCount() {
        return lottos.size();
    }

    public Map<LottoStatus, Integer> checkResult(Answer answer) {
        Map<LottoStatus, Integer> result = new HashMap<>();
        LottoStatus.getLottoStatusesExceptNone().stream().forEach(lottoStatus -> { result.put(lottoStatus, 0); });

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
