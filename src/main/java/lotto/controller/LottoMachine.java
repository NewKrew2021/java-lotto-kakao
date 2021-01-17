package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Set;

public class LottoMachine {
    private int userMoney;
    private int countOfAllTicket, countOfManualTicket, countOfAutoTicket;
    private LottoPaper manualLottoPaper, autoLottoPaper;
    private WinnerBalls winnerBalls;

    public void inputUserMoney() {
        int enteredMoney = Input.getPriceFromUser();
        if(!유효한_구입금액(enteredMoney)){
            throw new BadUserInputException("잘못된 금액 입력입니다.");
        }

        userMoney = enteredMoney;
        countOfAllTicket = userMoney / Ticket.TICKET_PRICE;
    }

    private boolean 유효한_구입금액(int money){
        return (0 <= money) && (0 == money % Ticket.TICKET_PRICE);
    }

    public void inputManualTicketCount() {
        int enteredTicketCount = Input.getNumberOfManualTicket();
        if (!구매가능한_티켓의_수(enteredTicketCount)) {
            throw new BadUserInputException("입력된 티켓의 수가 구입가능한 티켓의 수보다 많습니다.");
        }

        countOfManualTicket = enteredTicketCount;
    }

    public void purchasingManually(){
        List<Set<Integer>> manuallyEnteredNumbers = Input.getListOfTicketNumbersFromUser(countOfManualTicket);
        manualLottoPaper = new LottoPaper(new ManuallyGeneratingStrategy(manuallyEnteredNumbers));
    }

    private boolean 구매가능한_티켓의_수(int count){
        return (0 < count) && (count <= countOfAllTicket);
    }

    public void purchasingRemainsAutomatically() {
        countOfAutoTicket = countOfAllTicket - countOfManualTicket;
        autoLottoPaper = new LottoPaper(new RandomlyGeneratingStrategy(countOfAutoTicket));
    }

    public void printAllPurchasedLotto() {
        Output.printCountOfPurchase(countOfManualTicket, countOfAutoTicket);
        Output.printPurchasedLottoToUser(manualLottoPaper);
        Output.printPurchasedLottoToUser(autoLottoPaper);
    }

    public void inputWinnerInformation(boolean isRetried) {
        List<Integer> winningNumbers = Input.getWinnerNumbersFromUser(isRetried);
        int bonusBall = Input.getBonusBallFromUser();

        winnerBalls = new WinnerBalls(winningNumbers, bonusBall);
    }

    public void outputStatisticsAboutPurchasedLotto() {
        LottoPaper joinedPaper = LottoPaper.join(manualLottoPaper, autoLottoPaper);
        LottoResult result = joinedPaper.getResultCompareWith(winnerBalls);
        Output.printStatisticsToUser(result);
    }
}