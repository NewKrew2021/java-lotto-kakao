package lotto;

import lotto.domain.LottoSimulation;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulationApp {
    public static void main(String[] args) {
        Price price = new Price(InputView.getPrice());
        int manual = InputView.getManual(price.count());

        Lottos manualLottos = new Lottos(InputView.getManualLottos(manual));
        Lottos autoLottos = Lottos.getInstance(price.count() - manual);
        OutputView.printLottos(manualLottos, autoLottos);

        String text = InputView.getText();
        String bonus = InputView.getBonus();
        LottoSimulation lotto = new LottoSimulation(price, text, bonus, manualLottos.merge(autoLottos));

        lotto.confirm();
        OutputView.printResult(lotto);
        OutputView.printYield(lotto);
    }
}
