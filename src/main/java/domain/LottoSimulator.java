package domain;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSimulator {

    private static final long LOTTO_PRICE = 1000;
    private static final long PERCENTAGE = 100;

    private final long initial_money;
    private Lottos lottos;
    private Answer answer;

    public LottoSimulator(long initial_money, Lottos lottos, Answer answer) {
        this.initial_money = initial_money;
        this.lottos = lottos;
        this.answer = answer;
    }

    public int getWinningMoney() {
        Map<LottoStatus, Integer> lottoResult = lottos.checkResult(answer);
        return lottoResult.entrySet().stream().map(e -> e.getValue() * e.getKey().getWinnings()).reduce(Integer::sum).get();
    }

    public Map<LottoStatus, Integer> getLottoResults() {
        return lottos.checkResult(answer);
    }

    public long profitPercentage() {
        return (getWinningMoney() - initial_money) * PERCENTAGE / initial_money;
    }

    public long getBuyLottoCount() {
        return initial_money / LOTTO_PRICE;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
