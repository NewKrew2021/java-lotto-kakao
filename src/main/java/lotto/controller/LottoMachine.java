package lotto.controller;

import lotto.domain.*;
import lotto.domain.strategies.ManuallyGeneratingStrategy;
import lotto.domain.strategies.RandomlyGeneratingStrategy;
import lotto.exceptions.BadUserBehaviorException;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Set;

/**
 * Input 에서 'type 에 관한' 유효성검사를 담당합니다.
 * 그리고 '도메인적 지식이 필요한 부분' 은 각각의 도메인 객체에서 유효성 검사를 합니다.
 * 그러므로 controller 에서는 언급한 두가지를 제외하고, 'User 의 잘못된 조작(manipulate, control)' 에 관해서만 유효성 검사를 합니다.
 */
public class LottoMachine {
    private int userMoney;
    private int countOfAllTicket, countOfManualTicket, countOfAutoTicket;
    private LottoPapers lottoPapers = new LottoPapers();
    private WinnerBalls winnerBalls;

    public void inputUserMoney() {
        int enteredMoney = Input.getPriceFromUser();
        validateEnteredMoney(enteredMoney);

        userMoney = enteredMoney;
        countOfAllTicket = userMoney / Ticket.TICKET_PRICE;
    }

    private void validateEnteredMoney(int money) {
        if((money < 0) && (0 != money % Ticket.TICKET_PRICE)){
            throw new BadUserBehaviorException("잘못된 금액입니다. (금액은 0이상이어야 하고, 거스름돈이 남지 않아야 합니다.)");
        }
    }

    public void inputManualTicketCount() {
        int enteredTicketCount = Input.getNumberOfManualTicket();
        validateEnteredTicketCount(enteredTicketCount);

        countOfManualTicket = enteredTicketCount;
    }

    private void validateEnteredTicketCount(int count) {
        if((count < 0) && (countOfAllTicket < count)){
            throw new BadUserBehaviorException("입력된 티켓의 수가 구입가능한 티켓의 수보다 많습니다.");
        }
    }

    public void purchasingManually() {
        List<Set<Integer>> manuallyEnteredNumbers = Input.getListOfTicketNumbersFromUser(countOfManualTicket);
        LottoPaper manualLottoPaper = new LottoPaper(new ManuallyGeneratingStrategy(manuallyEnteredNumbers));
        lottoPapers.add(manualLottoPaper);
    }

    public void purchasingRemainsAutomatically() {
        countOfAutoTicket = countOfAllTicket - countOfManualTicket;
        LottoPaper autoLottoPaper = new LottoPaper(new RandomlyGeneratingStrategy(countOfAutoTicket));
        lottoPapers.add(autoLottoPaper);
    }

    public void printAllPurchasedLotto() {
        Output.printCountOfPurchase(countOfManualTicket, countOfAutoTicket);
        Output.printPurchasedLottoPapersToUser(lottoPapers);
    }

    public void inputWinnerInformation() {
        List<Integer> winningNumbers = Input.getWinnerNumbersFromUser();
        int bonusBall = Input.getBonusBallFromUser();

        winnerBalls = new WinnerBalls(winningNumbers, bonusBall);
    }

    public void outputStatisticsAboutPurchasedLotto() {
        LottoResult resultOfAllPapers = lottoPapers.getMergedPaper().getResultCompareWith(winnerBalls);
        Output.printStatisticsToUser(resultOfAllPapers);
    }
}