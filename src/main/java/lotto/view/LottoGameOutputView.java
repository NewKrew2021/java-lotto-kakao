package lotto.view;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseInformation;

public class LottoGameOutputView {
    private static final String TICKET_COUNT_SENTENCE = "\n수동으로 %d장, 자동으로 %d장 구매했습니다.\n";
    private static final String RESULT_SENTENCE = "당첨 통계";
    private static final String HORIZON_SEPARATOR = "--------------";
    private static final String RATE_SENTENCE = "총 수익률은 %s 입니다.\n";

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public static void printTicketCount(PurchaseInformation purchaseInformation) {
        System.out.printf(TICKET_COUNT_SENTENCE, purchaseInformation.getManualCount(), purchaseInformation.getAutoCount());
    }

    public static void printResult(LottoResults lottoResults) {
        System.out.println(RESULT_SENTENCE);
        System.out.println(HORIZON_SEPARATOR);
        System.out.println(lottoResults);
        System.out.printf(RATE_SENTENCE, lottoResults.calculateRate());
    }

}
