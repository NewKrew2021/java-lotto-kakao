package domain;

import utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
    private static final long PERCENTAGE = 100;
    private final long initialMoney;
    private final Lottos lottos;
    private AnswerLotto answerLotto;
    public long money;

    public LottoGame(long money) {
        this.money = money;
        initialMoney = money;
        lottos = new Lottos();
    }

    public boolean hasMoney() {
        return money >= Lotto.LOTTO_PRICE;
    }

    public void buyAutoLotto() {
        money -= Lotto.LOTTO_PRICE;
        addLotto(new RandomLottoGenerateStrategy());
    }

    public void addLotto(LottoGenerateStrategy lottoGenerateStrategy) {
        lottos.add(new Lotto(lottoGenerateStrategy));
    }

    public void addAnswerLotto(String inputTexts, int bonus) {
        List<Integer> lotto = StringUtils.splitText(inputTexts).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        answerLotto = new AnswerLotto(new Lotto(lotto), new LottoNumber(bonus));
    }

    public int getWinningMoney() {
        Map<LottoStatus, Integer> lottoResult = lottosResult();
        return lottoResult.entrySet().stream()
                .map(e -> e.getValue() * e.getKey().getWinngs())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public Map<LottoStatus, Integer> getLottoResults() {
        return lottosResult();
    }

    public long profitPercentage() {
        return getWinningMoney() * PERCENTAGE / initialMoney;
    }

    public long getBuyLottoCount() {
        return initialMoney / Lotto.LOTTO_PRICE;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Map<LottoStatus, Integer> lottosResult() {
        Map<LottoStatus, Integer> result = new HashMap<>();

        for (LottoStatus lottoStatus : LottoStatus.getLottoStatuses()) {
            result.put(lottoStatus, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            LottoStatus lottoStatus = answerLotto.getResult(lotto);
            insertIfNotNull(result, lottoStatus);
        }
        return result;
    }

    private void insertIfNotNull(Map<LottoStatus, Integer> result, LottoStatus lottoStatus) {
        if (lottoStatus != null) {
            result.put(lottoStatus, result.get(lottoStatus) + 1);
        }
    }
}
