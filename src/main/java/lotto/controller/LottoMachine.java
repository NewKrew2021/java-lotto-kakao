package lotto.controller;

import lotto.domain.*;
import lotto.domain.strategies.ManuallyGeneratingStrategy;
import lotto.domain.strategies.RandomlyGeneratingStrategy;
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
    private LottoPaper manualLottoPaper, autoLottoPaper;
    private WinnerBalls winnerBalls;

    public void inputUserMoney() {
        int enteredMoney = Input.getPriceFromUser();
        if(!유효한_구입금액(enteredMoney)) {
            throw new BadUserBehaviorException("잘못된 금액입니다. (금액은 0이상이어야 하고, 거스름돈이 남지 않아야 합니다.)");
        }

        userMoney = enteredMoney;
        countOfAllTicket = userMoney / Ticket.TICKET_PRICE;
    }

    private boolean 유효한_구입금액(int money) {
        return (0 <= money) && (0 == money % Ticket.TICKET_PRICE);
    }

    public void inputManualTicketCount() {
        int enteredTicketCount = Input.getNumberOfManualTicket();
        if (!구매가능한_티켓의_수(enteredTicketCount)) {
            throw new BadUserBehaviorException("입력된 티켓의 수가 구입가능한 티켓의 수보다 많습니다.");
        }

        countOfManualTicket = enteredTicketCount;
    }

    public void purchasingManually() {
        List<Set<Integer>> manuallyEnteredNumbers = Input.getListOfTicketNumbersFromUser(countOfManualTicket);
        manualLottoPaper = new LottoPaper(new ManuallyGeneratingStrategy(manuallyEnteredNumbers));
    }

    private boolean 구매가능한_티켓의_수(int count) {
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

    public void inputWinnerInformation() {
        List<Integer> winningNumbers = Input.getWinnerNumbersFromUser();
        int bonusBall = Input.getBonusBallFromUser();

        winnerBalls = new WinnerBalls(winningNumbers, bonusBall);
    }

    public void outputStatisticsAboutPurchasedLotto() {
        LottoPaper joinedPaper = LottoPaper.join(manualLottoPaper, autoLottoPaper);
        LottoResult result = joinedPaper.getResultCompareWith(winnerBalls);
        Output.printStatisticsToUser(result);
    }
}