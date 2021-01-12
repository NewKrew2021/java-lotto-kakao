package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.RandomlyGeneratingStrategy;
import lotto.domain.Ticket;
import lotto.domain.WinnerBalls;
import lotto.dto.LottoResult;
import lotto.setting.Format;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashSet;

/*
 * 컨트롤러에서는 view로부터 받은 입력에 대해 유효성 검사를 하지 않는다.
 * 컨트롤러는 view, domain을 적절히 호출하기만 할 뿐, 그 이상의 기능은 하지 않도록 한다.
 * domain과 관련된 유효성 검사는 오직 도메인에서만 처리하도록 한다.
 *
 * 하지만 잘못된 입력을 받으면 user로부터 다시 입력을 받도록 해야 한다.
 * 이 기능은 view, domain을 적절히 조합함으로써 이루어지는 기능이다.
 * 따라서 반복입력을 받는 부분은 컨트롤러가 맡는다.
 *
 * 컨트롤러는 view로 부터 밭은 원시값이 적절한 값인지 직접 알 필요가 없다.
 * 해당하는 도메인에게 메시지를 보내어서, 적절하지 않다고 판정이 나면, view에게 다시 input을 받아오도록 위임하도록 한다.
 *
 * 이와는 별개로, 만약 컨트롤러에서 잘못된 값으로 도메인 객체를 생성한다면,
 * 도메인 객체는 자체적으로 판단해서 exception을 발생시킨다.
 * 프로그램을 정상작동시키기 위해서 해당 exception을 처리하는 행위는 하지 않는다.
 * 이러한 exception이 발생했다는 것 자체가 로직이 잘못되었다는 것이다.
 * 객체를 생성하기 전에, 유효한지 체크한 후, 생성하기 때문이다.
 * 그러니 프로그램을 종료시키도록 한다.
 */
public class LottoMachine {
    private int userMoney, countOfPurchase;
    private LottoPaper userLottoPaper;
    private WinnerBalls winnerBalls;

    public void inputPrice() {
        userMoney = Input.getPriceFromUser();
        countOfPurchase = userMoney / Ticket.TICKET_PRICE; //TODO: 나중에 따로 빼면 좋을듯
        Output.printCountOfPurchase(countOfPurchase);
    }

    public void generateAuto() {
        userLottoPaper = LottoPaper.createBy(
                new RandomlyGeneratingStrategy(countOfPurchase)
        );
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
}