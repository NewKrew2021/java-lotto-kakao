package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulationApp {
    public static void main(String[] args) {
        Price price = new Price(InputView.getPrice());
        int manual = InputView.getManual(price.count());

        Lottos manualLottos = new Lottos(InputView.getManualLottos(manual));
        Lottos autoLottos = Lottos.getAutoLottos(price.count() - manual);
        OutputView.printLottos(manualLottos, autoLottos);

        String text = InputView.getText();
        String bonus = InputView.getBonus();
        WinningLotto winningLotto = new WinningLotto(Lotto.of(text), new LottoNumber(Integer.parseInt(bonus)));
        LottoSimulation lotto = new LottoSimulation(price, winningLotto, manualLottos.merge(autoLottos));

        lotto.confirm();
        OutputView.printResult(lotto);
        OutputView.printYield(lotto);
    }
}
