package lotto;

import lotto.domain.LottoSimulation;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulationApp {
    public static void main(String[] args) {
        Price price = new Price(InputView.getPrice());
        OutputView.printLottoCount(price);

        Lottos lottos = Lottos.getInstance(price.count());
        OutputView.printLottos(lottos);

        String text = InputView.getText();
        String bonus = InputView.getBonus();

        LottoSimulation lotto = new LottoSimulation(price, text, bonus, lottos);

        lotto.confirm();
        OutputView.printResult(lotto);
        OutputView.printYield(lotto);
    }
}
