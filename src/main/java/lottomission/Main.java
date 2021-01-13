package lottomission;

import lottomission.domain.*;
import lottomission.domain.exception.InvalidSelfLottoCountException;
import lottomission.util.CalculatorForLotto;
import lottomission.view.InputView;
import lottomission.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserMoney userMoney = new UserMoney(InputView.enterUerMoney());
        int selfLottoCount = InputView.enterSelfLottoCount();
        if(userMoney.getPossibleCount() < selfLottoCount){
            throw new InvalidSelfLottoCountException();
        }
        List<List<Integer>> selfLottosNumberList = InputView.enterSelfLottoNumbers(
                selfLottoCount);

        LottoGame lottoGame = new LottoGame();
        Lottos lottos = lottoGame.buyLottos(userMoney, selfLottosNumberList);
        OutputView.lottoBoughtView(lottos, selfLottoCount);

        List<Integer> lottoAnswerNumberList = InputView.enterLastWeekWinningNumbers();
        int lottoAnswerBonusNumber = InputView.enterLastWeekBonusNumber();
        LottoAnswer lottoAnswer = new LottoAnswer(
                new LottoNumbers(lottoAnswerNumberList),
                new LottoNumber(lottoAnswerBonusNumber)
        );

        CalculatorForLotto cal = new CalculatorForLotto();
        LottoResult lottoResult = lottoGame.getLottoGameResult(lottos, lottoAnswer);
        OutputView.resultView(lottoResult);
        OutputView.totalEarningsView(cal.rateOfProfit(userMoney.getUserMoney(),lottoResult.getSumAllWinningMoney()));
    }
}