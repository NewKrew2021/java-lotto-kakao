package lotto;

import lotto.controller.LottoController;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.buyLotto();
        lottoController.getWinningNumber();
        lottoController.matchLotto();
    }
}
