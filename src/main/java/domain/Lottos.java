package domain;

import java.util.*;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public Lottos(int lottoMoney) {
        lottos = new ArrayList<>();
        for (int currentMoney = 0; currentMoney < lottoMoney; currentMoney += LOTTO_PRICE) {
            lottos.add(new Lotto(new RandomLottoStrategy().NumberChooseStrategy()));
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoStatus, Integer> checkResult(Answer answer) {
        Map<LottoStatus, Integer> result = new HashMap<>();

        for (LottoStatus lottoStatus : LottoStatus.getLottoStatuses()) {
            result.put(lottoStatus, 0);
        }
        for (Lotto lotto : lottos) {
            LottoStatus lottoStatus = lotto.getResult(answer);
            if (lottoStatus != null) {
                result.put(lottoStatus, result.get(lottoStatus) + 1);
            }
        }
        return result;
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
