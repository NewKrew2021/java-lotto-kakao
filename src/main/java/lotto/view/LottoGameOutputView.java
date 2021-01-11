package lotto.view;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;

public class LottoGameOutputView {
    private static final String TICKET_COUNT_SENTENCE = "%d개를 구매했습니다.\n";
    private static final String RESULT_SENTENCE = "당첨 통계";
    private static final String HORIZON_SEPARATOR = "--------------";
    private static final String RATE_SENTENCE = "총 수익률은 %s 입니다.\n";

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
