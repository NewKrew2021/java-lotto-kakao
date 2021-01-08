package domain;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSimulator {

    private static final long LOTTO_PRICE = 1000;
    private static final long PERCENTAGE = 100;

    private final long initialMoney;
    public long money;
    private LottoManager lottoManager;
    private final List<Lotto> lottos;
    private AnswerLotto answerLotto;
    private final LottoNumberMaker lottoNumberMaker;

    public LottoSimulator(long money) {
        this.money = money;
        lottos = new ArrayList<>();
        initialMoney = money;
        lottoNumberMaker = new LottoNumberMaker();
    }

    public boolean hasMoney() {
        return money >= LOTTO_PRICE;
    }

    public void buyAutoLotto() {
        money -= LOTTO_PRICE;
        addLotto(new RandomLottoStrategy());
    }

    public void addLotto(LottoStrategy lottoStrategy) {
        lottos.add(new Lotto(lottoNumberMaker.generateLottoNumbers(lottoStrategy)));
    }

    public void addAnswerLotto(String inputTexts, int bonus) {
        answerLotto = new AnswerLotto(lottoNumberMaker.makeLottoNumberFromStrings(StringUtils.splitText(inputTexts)), bonus);
    }

    public void setLottoManager() {
        lottoManager = new LottoManager(new Lottos(lottos), answerLotto);
    }

    public int getWinningMoney() {
        Map<LottoStatus, Integer> lottoResult = lottoManager.lottosResult();
        return lottoResult.entrySet().stream().map(e -> e.getValue() * e.getKey().getWinngs()).reduce(Integer::sum)
                .orElse(0);
    }

    public Map<LottoStatus, Integer> getLottoResults() {
        return lottoManager.lottosResult();
    }

    public long profitPercentage() {
        return getWinningMoney() * PERCENTAGE / initialMoney;
    }

    public long getBuyLottoCount() {
        return initialMoney / LOTTO_PRICE;
    }

    public Lottos getLottos() {
        return new Lottos(lottos);
    }
}
