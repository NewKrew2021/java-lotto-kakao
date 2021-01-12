package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.LottoPaperGenerator;
import lotto.domain.Ticket;
import lotto.domain.WinnerBalls;
import lotto.dto.LottoResult;
import lotto.setting.Format;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashSet;

public class LottoMachine {
    private int userMoney;
    private LottoPaper userLottoPaper;
    private WinnerBalls winnerBalls;

    public void inputPrice() {
        userMoney = Input.getPriceFromUser();
        Output.printCountOfPurchase(userMoney / Format.TICKET_PRICE);
    }

    public void generateAuto() {
        userLottoPaper = new LottoPaperGenerator(userMoney).generateAuto();
    }

    public void outputAboutPurchasedLotto(){
        Output.printPurchasedLottoToUser(userLottoPaper);
    }

    public void inputWinnerInformation(){
        Ticket winnerTicket = new Ticket(new HashSet<>(Input.getWinnerNumbersFromUser()));
        int bonusBall = Input.getBonusBallFromUser();
        winnerBalls = new WinnerBalls(winnerTicket, bonusBall);
    }

    public void outputStatisticsAboutPurchasedLotto() {
        LottoResult result = userLottoPaper.getResultCompareWith(winnerBalls);
        Output.printStatisticsToUser(userMoney, result);
    }

    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        machine.inputPrice();
        machine.generateAuto();
        machine.outputAboutPurchasedLotto();
        machine.inputWinnerInformation();
        machine.outputStatisticsAboutPurchasedLotto();
    }
}