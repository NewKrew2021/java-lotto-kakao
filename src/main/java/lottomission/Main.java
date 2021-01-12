package lottomission;

import lottomission.domain.*;
import lottomission.view.InputView;
import lottomission.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserMoney userMoney = new UserMoney(InputView.enterUerMoney());

        LottoGame lottoGame = new LottoGame();
        Lottos lottos = lottoGame.buyLottos(userMoney);
        OutputView.autoBoughtView(lottos);

        List<Integer> lottoAnswerNumberList = InputView.enterLastWeekWinningNumbers();
        int lottoAnswerBonusNumber = InputView.enterLastWeekBonusNumber();
        LottoAnswer lottoAnswer = new LottoAnswer(
                new LottoNumbers(lottoAnswerNumberList),
                new LottoNumber(lottoAnswerBonusNumber)
        );

        LottoResult lottoResult = lottoGame.getLottoGameResult(lottos, lottoAnswer);
        OutputView.resultView(lottoResult);
        OutputView.totalEarningsView(lottoResult, userMoney);
    }
}