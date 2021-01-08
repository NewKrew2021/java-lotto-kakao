package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.LottoPaperGenerator;
import lotto.domain.WinnerBalls;
import lotto.dto.LottoResult;
import lotto.setting.Format;
import lotto.view.Input;
import lotto.view.Output;

public class LottoMachine {
    private int userMoney;
    private LottoPaper userLottoPaper;
    private WinnerBalls winnerBalls;

    public void inputPrice(){
        userMoney = Input.getPriceFromUser();
        Output.printCountOfPurchase(userMoney / Format.TICKET_PRICE);
    }

    public void generateAuto(){
        userLottoPaper = new LottoPaperGenerator(userMoney).generateAuto();
    }

    public void outputAboutPurchasedLotto(){
        Output.printPurchasedLottoToUser(userLottoPaper);
    }

    public void inputWinnerInformation(){
        winnerBalls = Input.getWinnerBallsFromUser();
    }

    public void outputStatisticsAboutPurchasedLotto(){
        LottoResult result = userLottoPaper.getResultCompareWith(winnerBalls);
        Output.printStatisticsToUser(userMoney, result);
    }
}