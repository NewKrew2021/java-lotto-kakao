import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSimulator {

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private final int initial_money;
    public int money;
    private LottoManager lottoManager;
    private List<Lotto> lottos;
    private AnswerLotto answerLotto;
    private LottoNumberMaker lottoNumberMaker;

    public LottoSimulator(int money) {
        this.money = money;
        lottos = new ArrayList<>();
        initial_money = money;
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

    public void addAnswerLotto(List<Integer> lottoNumbers, int bonusNumber) {
        answerLotto = new AnswerLotto(lottoNumbers, bonusNumber);
    }

    public void setLottoManager() {
        lottoManager = new LottoManager(new Lottos(lottos), answerLotto);
    }

    public int getWinningMoney() {
        Map<LottoStatus, Integer> lottoResult = lottoManager.checkResult();

        return lottoResult.entrySet().stream().map(e->e.getValue() * e.getKey().getWinngs()).reduce(Integer::sum).get();
    }

    public int profitPercentage() {
        return getWinningMoney() * PERCENTAGE / initial_money ;
    }
}
