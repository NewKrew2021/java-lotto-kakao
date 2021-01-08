package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.LottoPaperGenerator;
import lotto.domain.WinnerBalls;
import lotto.dto.LottoResult;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000; //TODO 프로퍼티가 너무 많나??
    private int userMoney;
    private LottoPaper userLottoPaper;
    private WinnerBalls winnerBalls;

    public void inputPrice(){
        userMoney = Input.getPriceFromUser();
        Output.printCountOfPurchase(userMoney / TICKET_PRICE);
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