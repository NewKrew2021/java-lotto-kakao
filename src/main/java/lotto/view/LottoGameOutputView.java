package lotto.view;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;

public class LottoGameOutputView {

    private static final String ASK_PRICE_SENTENCE = "구입 금액을 입력해 주세요.";
    private static final String ASK_WINNER_NUMBER_SENTENCE = "지난 주 당첨번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_SENTENCE = "보너스 볼을 입력해 주세요.";
    private static final String TICKET_COUNT_SENTENCE = "%d개를 구매했습니다.";
    private static final String RESULT_SENTENCE = "당첨 통계";
    private static final String HORIZON_SEPARATOR = "--------------";
    private static final String RATE_SENTENCE = "총 수익률은 %s 입니다.";


    public static void askPrice() {
        System.out.println(ASK_PRICE_SENTENCE);
    }

    public static void askWinnerNumber() {
        System.out.println(ASK_WINNER_NUMBER_SENTENCE);
    }

    public static void askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_SENTENCE);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.printf(TICKET_COUNT_SENTENCE, lottoTickets.getTicketCount());
        System.out.println(lottoTickets);
    }

    public static void printResult(LottoResults lottoResults, int price) {
        System.out.println(RESULT_SENTENCE);
        System.out.println(HORIZON_SEPARATOR);
        System.out.println(lottoResults);
        System.out.printf(RATE_SENTENCE, lottoResults.calculateRate(price));
    }

}
